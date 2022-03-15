package sk.stuba.fei.uim.vsa.ui.command;

import java.util.List;

public class PrintCommand implements Command{

    @Override
    public void execute(String wholeInput, List<String> parameters) {
        System.out.println(wholeInput.substring(wholeInput.indexOf(' ')));
    }
}
