package ch.fhnw.depa.mcsquanchy;

public class MechanicalPart implements MachinePart {
    private final String partNumber;
    private final double partPrice;

    public MechanicalPart(String partNo, double price) {
        this.partNumber = partNo;
        this.partPrice = price;
    }

    @Override
    public MachinePart makeCopy() {
        MechanicalPart mechanicalPartObject = null;

        try {
            mechanicalPartObject = (MechanicalPart) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return mechanicalPartObject;
    }

    @Override
    public String toString() {
        return "PartNo.: " + this.partNumber + ", Price: " + this.partPrice + ", Hashcode: " + System.identityHashCode(this);
    }
}
