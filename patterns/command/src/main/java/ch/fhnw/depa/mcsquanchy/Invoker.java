package ch.fhnw.depa.mcsquanchy;


import java.util.*;

public class Invoker {
    private final List<Command> stack = new ArrayList<>();
    private int iteratorPosition = 0;

    public Invoker(Command cmdA) {
        stack.add(cmdA);
        cmdA.execute();
    }

    public void setCommand(Command cmd) {
        stack.add(cmd);
        this.iteratorPosition += 1;
        cmd.execute();
    }

    public void undo() {
        this.stack.get(Math.max((iteratorPosition - 1), 0)).unexecute();
        this.iteratorPosition = Math.max(this.iteratorPosition-1, 0);
    }

    public void redo() {
        this.iteratorPosition = Math.min(this.iteratorPosition+1, stack.size()-1);
        this.stack.get(this.iteratorPosition).execute();

    }

}
