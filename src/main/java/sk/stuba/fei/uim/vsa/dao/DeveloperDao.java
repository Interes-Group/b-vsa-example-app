package sk.stuba.fei.uim.vsa.dao;

import sk.stuba.fei.uim.vsa.domain.Developer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DeveloperDao extends AbstractDao<Developer> {

    public DeveloperDao(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    @Override
    public Optional<Developer> get(Long id) {
        return super.getOne(id, Developer.class);
    }

    @Override
    public List<Developer> getAll() {
        return super.getAll("DEVELOPER", Developer.class);
    }

    @Override
    public List<Developer> find(String query, Map<String, Object> parameters) {
        return super.find(query, parameters, Developer.class);
    }
}
