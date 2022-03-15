package sk.stuba.fei.uim.vsa.ui.command;

import java.util.List;

public interface Command {

    public void execute(String wholeInput, List<String> parameters);

}
