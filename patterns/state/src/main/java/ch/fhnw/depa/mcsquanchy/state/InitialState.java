package ch.fhnw.depa.mcsquanchy.state;

import ch.fhnw.depa.mcsquanchy.ConcreteContext;

public class InitialState implements IState {

    private final ConcreteContext context;

    public InitialState (ConcreteContext ctx) {
        context = ctx;
    }

    @Override
    public void handle() {
        System.out.println("Starting state");
        this.context.changeState(new FinalState(this.context));
    }
}
