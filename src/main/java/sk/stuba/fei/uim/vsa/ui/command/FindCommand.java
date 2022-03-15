package sk.stuba.fei.uim.vsa.ui.command;

import sk.stuba.fei.uim.vsa.domain.Game;
import sk.stuba.fei.uim.vsa.service.GameService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindCommand implements Command {

    private GameService gameService;

    public FindCommand() {
        this.gameService = new GameService();
    }

    @Override
    public void execute(String wholeInput, List<String> parameters) {
        List<Game> games = new ArrayList<>();
        switch (parameters.get(0)) {
            case "game":
                parameters.remove(0);
                games = findGames(parameters);
                break;
            default:
                printNoCommand(parameters);
                return;
        }
        if (games.isEmpty())
            printNoResult(parameters);
        else
            printGames(games);
    }

    private List<Game> findGames(List<String> params) {
        switch (params.get(0)) {
            case "byId":
            case "byid":
                params.remove(0);
                return findGameById(params);
            case "all":
                return new ArrayList<>();
            default:
                printNoCommand(params);
                return new ArrayList<>();
        }
    }

    private List<Game> findGameById(List<String> params) {
        Long id = Long.parseLong(params.get(0));
        Game game = gameService.getGame(id);
        return Collections.singletonList(game);
    }

    private void printNoResult(List<String> params) {
        System.out.println("No result for parameters '" + String.join(" ", params) + "' were found.");
    }

    private void printNoCommand(List<String> params) {
        System.out.println("Unrecognised parameters! Parameters '" + String.join(" ", params) + "' has not been recognised!");
    }

    private void printGames(List<Game> games) {
        games.forEach(game -> {
            System.out.println(game);
        });
    }

}
