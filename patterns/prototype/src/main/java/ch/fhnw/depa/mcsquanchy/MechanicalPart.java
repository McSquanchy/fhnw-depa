package ch.fhnw.depa.mcsquanchy;

public class MechanicalPart implements MachinePart {
    private final String partNumber;
    private final double partPrice;

    public MechanicalPart(String partNo, double price) {
        this.partNumber = partNo;
        this.partPrice = price;
    }

    @Override
    public MechanicalPart clone() {
        try {
            return (MechanicalPart) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override
    public String toString() {
        return "PartNo.: " + this.partNumber + ", Price: " + this.partPrice + ", Hashcode: " + System.identityHashCode(this);
    }
}
