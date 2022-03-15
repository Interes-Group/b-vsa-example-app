package sk.stuba.fei.uim.vsa.dao;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.vsa.domain.Developer;
import sk.stuba.fei.uim.vsa.domain.DomainEntity;
import sk.stuba.fei.uim.vsa.domain.Game;
import sk.stuba.fei.uim.vsa.domain.Publisher;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {

    private static DaoFactory instance;

    @Getter
    @Setter
    private String puName;

    private Map<String, AbstractDao> daos;

    public static DaoFactory getInstance(String persistenceUnitName) {
        if (instance == null)
            instance = new DaoFactory(persistenceUnitName);
        return instance;
    }

    private DaoFactory(String persistenceUnitName) {
        this.puName = persistenceUnitName;
        daos = new HashMap<>();
    }

    public <T extends DomainEntity> AbstractDao<T> getDao(Class<T> clazz) {
        if (daos.containsKey(clazz.getName())) {
            return daos.get(clazz.getName());
        }
        return createDao(clazz);
    }

    private <T extends DomainEntity> AbstractDao createDao(Class<T> clazz) {
        if (clazz.equals(Game.class))
            return save(new GameDao(puName));
        if (clazz.equals(Developer.class))
            return save(new DeveloperDao(puName));
        if (clazz.equals(Publisher.class))
            return save(new PublisherDao(puName));
        else
            return null;
    }

    private AbstractDao save(AbstractDao dao) {
        daos.put(dao.getClass().getName(), dao);
        return dao;
    }

}
