package sk.stuba.fei.uim.vsa.service;

import sk.stuba.fei.uim.vsa.dao.DaoFactory;
import sk.stuba.fei.uim.vsa.dao.GameDao;
import sk.stuba.fei.uim.vsa.domain.Game;
import sk.stuba.fei.uim.vsa.domain.Genre;

import java.util.Optional;

public class GameService {

    private final GameDao dao;

    public GameService() {
        dao = (GameDao) DaoFactory.getInstance("default").getDao(Game.class);
    }

    public Game getGame(Long id) {
        try {
            Optional<Game> game = dao.get(id);
            return game.orElse(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Game publish(String name, Genre... genres) {
        Game game = new Game(name, genres);
        dao.save(game);
        return game;
    }


}
