package ch.fhnw.depa.mcsquanchy;

public class Main {

    public static void main(String[] args) {
        Printer p = new Printer(new RegularPrintStrategy());
        p.doPrint();

        Printer f = new Printer(new SpecialPrintStrategy());
        f.doPrint();

        Printer j = new Printer(() -> {
           System.out.println("CustomPrintStrategy");
        });
        j.doPrint();
    }
}
