package ch.fhnw.depa.mcsquanchy;

public abstract class AbstractContext {

    public abstract void request();

    public void printError() {
        System.err.println("Couldn't handle request. Please try again!");
    }
}
