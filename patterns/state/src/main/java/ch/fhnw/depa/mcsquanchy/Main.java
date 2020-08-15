package ch.fhnw.depa.mcsquanchy;

public class Main {
    public static void main(String[] args) {
        ConcreteContext n = new ConcreteContext();

        System.out.println(n.getState().getClass().toString());
        n.request();
        System.out.println(n.getState().getClass().toString());
        n.request();
    }
}
