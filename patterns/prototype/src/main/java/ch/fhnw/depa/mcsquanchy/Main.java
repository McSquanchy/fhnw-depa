package ch.fhnw.depa.mcsquanchy;

public class Main {

    public static void main(String[] args) {

        PartFactory factory = new PartFactory();

        StructuralPart beam = new StructuralPart("8103.2", 49.50);
        MechanicalPart gearBox = new MechanicalPart("1421.9", 399.50);

        StructuralPart beamClone = (StructuralPart) factory.getClone(beam);

        System.out.println(beam);
        System.out.println(beamClone);

        MechanicalPart gearBoxClone = (MechanicalPart) factory.getClone(gearBox);

        System.out.println(gearBox);
        System.out.println(gearBoxClone);
        
    }
}
