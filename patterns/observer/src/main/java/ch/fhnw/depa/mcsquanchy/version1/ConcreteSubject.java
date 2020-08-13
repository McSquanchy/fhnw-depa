package ch.fhnw.depa.mcsquanchy.version1;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcreteSubject implements ISubject {
    private final HashSet<IObserver> observers = new HashSet<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.iterator().forEachRemaining(IObserver::update);
    }

    public int getState() {
        return this.counter.get();
    }

    public void setState() {
        this.counter.getAndIncrement();
    }
}
