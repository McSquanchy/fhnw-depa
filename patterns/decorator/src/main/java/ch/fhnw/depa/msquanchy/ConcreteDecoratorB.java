package ch.fhnw.depa.msquanchy;

public class ConcreteDecoratorB extends Decorator {

    private final Component wrappedComponent;

    public ConcreteDecoratorB(Component wrappedObj) {
        this.wrappedComponent = wrappedObj;
    }

    @Override
    public double cost() {
        return this.wrappedComponent.cost() + 0.60;
    }
}
