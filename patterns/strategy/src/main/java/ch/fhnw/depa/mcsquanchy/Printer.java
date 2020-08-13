package ch.fhnw.depa.mcsquanchy;

public class Printer {
    private final IPrintStrategy strategy;

    public Printer(IPrintStrategy strat) {
        this.strategy = strat;
    }

    public void doPrint() {
        strategy.print();
    }
}
