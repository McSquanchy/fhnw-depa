package ch.fhnw.depa.mcsquanchy;

public class Main {

    public static void main(String[] args) {

        StructuralPart beam = new StructuralPart("8103.2", 49.50);
        MechanicalPart gearBox = new MechanicalPart("1421.9", 399.50);

        StructuralPart beamClone = beam.clone();

        System.out.println(beam);
        System.out.println(beamClone);

        MechanicalPart gearBoxClone = gearBox.clone();

        System.out.println(gearBox);
        System.out.println(gearBoxClone);
        
    }
}
