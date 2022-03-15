package sk.stuba.fei.uim.vsa.ui.command;

import sk.stuba.fei.uim.vsa.domain.Game;
import sk.stuba.fei.uim.vsa.domain.Genre;
import sk.stuba.fei.uim.vsa.service.GameService;

import java.util.List;
import java.util.stream.Collectors;

public class CreateCommand implements Command {

    private GameService gameService;

    public CreateCommand() {
        this.gameService = new GameService();
    }

    @Override
    public void execute(String wholeInput, List<String> parameters) {
        switch (parameters.get(0)) {
            case "game":
                parameters.remove(0);
                createGame(parameters);
                break;
            default:
                printNoCommand(parameters);
                return;
        }
    }

    private Game createGame(List<String> params) {
        String name = params.get(0);
        params.remove(0);
        Game game = gameService.publish(name, params.stream().map(p -> Genre.valueOf(p.toUpperCase())).collect(Collectors.toList()).toArray(new Genre[]{}));
        System.out.println(game);
        return game;
    }

    private void printNoResult(List<String> params) {
        System.out.println("No result for parameters '" + String.join(" ", params) + "' were found.");
    }

    private void printNoCommand(List<String> params) {
        System.out.println("Unrecognised parameters! Parameters '" + String.join(" ", params) + "' has not been recognised!");
    }
}
