package sk.stuba.fei.uim.vsa;

import sk.stuba.fei.uim.vsa.ui.KeyboardInput;
import sk.stuba.fei.uim.vsa.ui.Repl;

public class VsaApplication {

    public static void main(String[] args) {
        KeyboardInput.PROMPT_DELIMETER = ">";
        Repl repl = new Repl();
        repl.start();
    }

}
