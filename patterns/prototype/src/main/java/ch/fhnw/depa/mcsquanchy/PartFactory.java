package ch.fhnw.depa.mcsquanchy;

public class PartFactory {

    public MachinePart getClone(MachinePart sample) {
        return sample.makeCopy();
    }
}
