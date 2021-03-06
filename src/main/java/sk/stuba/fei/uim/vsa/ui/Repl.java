package sk.stuba.fei.uim.vsa.ui;

import sk.stuba.fei.uim.vsa.ui.command.*;

import java.util.*;

public class Repl {

    private final Map<String, Command> commands;

    public Repl() {
        this.commands = new HashMap<>();
        commands.put("print", new PrintCommand());
        commands.put("help", new HelpCommand());
        commands.put("?", new HelpCommand());
        commands.put("find", new FindCommand());
        commands.put("create", new CreateCommand());
    }

    public void start() {
        while (true) {
            String input = KeyboardInput.readString("").trim();
            switch (input) {
                case "q":
                case "exit":
                case "quit":
                    return;
            }
            if (isCommand(input)) {
                executeCommand(input);
            } else {
                System.out.println("Input '" + input + "' was not recognised as a known command!");
                executeCommand("help");
            }
        }
    }

    private String getCommand(String input) {
        String command = "";
        if (!input.contains(" ")) {
            command = input.trim();
        } else {
            command = input.substring(0, input.indexOf(' '));
        }
        return command;
    }

    private boolean isCommand(String input) {
        return commands.containsKey(getCommand(input));
    }

    private void executeCommand(String input) {
        if (!isCommand(input)) return;
        String command = getCommand(input);
        List<String> parameters = new ArrayList<>(Arrays.asList(input.split(" ")));
        parameters.remove(0);
        commands.get(command).execute(input, parameters);
    }
}
