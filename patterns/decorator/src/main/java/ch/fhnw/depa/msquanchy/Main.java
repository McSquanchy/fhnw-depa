package ch.fhnw.depa.msquanchy;

public class Main {

    public static void main(String[] args) {
        ConcreteComponentA obj = new ConcreteComponentA();
        System.out.printf("(%s, %.2f)%n", obj.getDescription(), obj.cost());
        ConcreteDecoratorA firstWrapper = new ConcreteDecoratorA(obj);
        ConcreteDecoratorB secondWrapper = new ConcreteDecoratorB(firstWrapper);
        System.out.printf("(%s, %.2f)%n", secondWrapper.getDescription(), secondWrapper.cost());
    }

}
