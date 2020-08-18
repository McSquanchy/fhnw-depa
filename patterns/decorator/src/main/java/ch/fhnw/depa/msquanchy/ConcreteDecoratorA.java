package ch.fhnw.depa.msquanchy;

public class ConcreteDecoratorA extends Decorator {
    private final Component wrappedComponent;

    public ConcreteDecoratorA(Component wrappedObj) {
        this.wrappedComponent = wrappedObj;
    }

    @Override
    public double cost() {
        return this.wrappedComponent.cost() + 0.25;
    }
}
