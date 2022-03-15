package sk.stuba.fei.uim.vsa.dao;

import sk.stuba.fei.uim.vsa.domain.DomainEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class AbstractDao<T extends DomainEntity> implements IDao<T> {

    protected final EntityManagerFactory emf;

    protected AbstractDao(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName == null ? "default" : persistenceUnitName);
    }

    protected Optional<T> getOne(Long id, Class<T> clazz) {
        EntityManager em = emf.createEntityManager();
        T entity = em.find(clazz, id);
        em.close();
        return Optional.ofNullable(entity);
    }

    protected List<T> getAll(String tableName, Class<T> clazz) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM " + tableName, clazz);
        List<T> resultList = (List<T>) query.getResultList();
        em.close();
        return resultList;
    }

    protected List<T> find(String query, Map<String, Object> parameters, Class<T> clazz) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<T> typedQuery;
        if (query.startsWith(clazz.getName() + ".")) {
            typedQuery = em.createNamedQuery(query, clazz);
        } else {
            typedQuery = em.createQuery(query, clazz);
        }
        List<T> resultList = typedQuery.getResultList();
        em.close();
        return resultList;
    }

    @Override
    public void save(T entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            executeTransaction(em -> em.persist(entity));
        } else {
            executeTransaction(em -> em.merge(entity));
        }
    }

    @Override
    public void delete(T entity) {
        executeTransaction(em -> em.remove(entity));
    }

    @Override
    public void close() {
        emf.close();
    }

    public void executeTransaction(Consumer<EntityManager> execution) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            execution.accept(em);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
        }
        em.close();
    }


}
