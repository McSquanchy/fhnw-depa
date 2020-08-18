package ch.fhnw.depa.mcsquanchy;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Set<Component> testSet1 = Stream.of(new Leaf("Feed cat"), new Leaf("Feed dog")).collect(Collectors.toSet());
        Set<Component> testSet2 = Stream.of(new Leaf("Water plant"), new Leaf("Clean windows")).collect(Collectors.toSet());
        Composite testComposite1 = new Composite("Animal Care", testSet1);
        Composite testComposite2 = new Composite("House Keeping", testSet2);
        Set<Component> holidays = Stream.of(testComposite1, testComposite2).collect(Collectors.toSet());
        Composite holidayComposite = new Composite("Vacation Tasks", holidays);
        System.out.println(holidayComposite.getHtml());
    }
}
