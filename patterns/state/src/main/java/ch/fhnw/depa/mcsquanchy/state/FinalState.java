package ch.fhnw.depa.mcsquanchy.state;

import ch.fhnw.depa.mcsquanchy.ConcreteContext;

public class FinalState implements IState {
    private final ConcreteContext context;

    public FinalState(ConcreteContext ctx) {
        context = ctx;
    }

    @Override
    public void handle() {
        System.out.println("Final state");
    }
}
