package ch.fhnw.depa.mcsquanchy;

public class StructuralPart implements MachinePart {
    private final String partNumber;
    private final double partPrice;

    public StructuralPart(String partNo, double price) {
        this.partNumber = partNo;
        this.partPrice = price;
    }

    @Override
    public StructuralPart clone() {
        try {
            return (StructuralPart) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override
    public String toString() {
        return "PartNo.: " + this.partNumber + ", Price: " + this.partPrice + ", Hashcode: " + System.identityHashCode(this);
    }

}
