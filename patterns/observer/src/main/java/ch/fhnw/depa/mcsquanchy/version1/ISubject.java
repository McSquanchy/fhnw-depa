package ch.fhnw.depa.mcsquanchy.version1;

import ch.fhnw.depa.mcsquanchy.version1.IObserver;

public interface ISubject {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}
