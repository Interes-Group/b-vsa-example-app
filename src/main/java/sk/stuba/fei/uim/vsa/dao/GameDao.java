package sk.stuba.fei.uim.vsa.dao;

import sk.stuba.fei.uim.vsa.domain.Game;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GameDao extends AbstractDao<Game> {

    public GameDao(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    @Override
    public Optional<Game> get(Long id) {
        return super.getOne(id, Game.class);
    }

    @Override
    public List<Game> getAll() {
        return super.getAll("GAME", Game.class);
    }

    @Override
    public List<Game> find(String query, Map<String, Object> parameters) {
        return super.find(query, parameters, Game.class);
    }
}
