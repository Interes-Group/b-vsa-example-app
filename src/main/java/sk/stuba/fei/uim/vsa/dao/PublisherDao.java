package sk.stuba.fei.uim.vsa.dao;

import sk.stuba.fei.uim.vsa.domain.Publisher;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PublisherDao extends AbstractDao<Publisher> {

    public PublisherDao(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    @Override
    public Optional<Publisher> get(Long id) {
        return super.getOne(id, Publisher.class);
    }

    @Override
    public List<Publisher> getAll() {
        return super.getAll("PUBLISHER", Publisher.class);
    }

    @Override
    public List<Publisher> find(String query, Map<String, Object> parameters) {
        return super.find(query, parameters, Publisher.class);
    }
}
