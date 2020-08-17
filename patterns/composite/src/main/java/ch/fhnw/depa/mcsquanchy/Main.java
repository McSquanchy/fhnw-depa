package ch.fhnw.depa.mcsquanchy;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Set<Component> testSet1 = Stream.of(new Leaf("Feed cat"), new Leaf("Feed dog")).collect(Collectors.toSet());
        Set<Component> testSet2 = Stream.of(new Leaf("Water plant"), new Leaf("Clean windows")).collect(Collectors.toSet());
        Node testNode1 = new Node("Animal Care", testSet1);
        Node testNode2 = new Node("House Keeping", testSet2);
        Set<Component> holidays = Stream.of(testNode1, testNode2).collect(Collectors.toSet());
        Node holidayNode = new Node("Vacation Tasks", holidays);
        System.out.println(holidayNode.getHtml());
    }
}
