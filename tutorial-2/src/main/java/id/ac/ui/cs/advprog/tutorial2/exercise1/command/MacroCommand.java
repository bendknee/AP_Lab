package id.ac.ui.cs.advprog.tutorial2.exercise1.command;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class MacroCommand implements Command {

    private List<Command> commands;

    public MacroCommand(Command[] commands) {
        this.commands = Arrays.asList(commands);
    }

    @Override
    public void execute() {
        for (int i = 0 ; i < commands.size() ; i++) {
            commands.get(i).execute();
        }
    }

    @Override
    public void undo() {
        for (int i = commands.size()-1 ; i > -1 ; i--) {
            commands.get(i).undo();
        }
    }
}
