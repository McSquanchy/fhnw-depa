package ch.fhnw.depa.mcsquanchy;

import ch.fhnw.depa.mcsquanchy.state.IState;
import ch.fhnw.depa.mcsquanchy.state.InitialState;

public class ConcreteContext extends AbstractContext {
    private IState state;

    public ConcreteContext() {
        this.state = new InitialState(this);
    }

    @Override
    public void request() {
        state.handle();
    }

    public void changeState(IState newState) {
        this.state = newState;
    }

    public IState getState() {
        return state;
    }
}

