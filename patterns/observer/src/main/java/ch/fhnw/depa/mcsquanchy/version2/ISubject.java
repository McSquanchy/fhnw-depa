package ch.fhnw.depa.mcsquanchy.version2;

public interface ISubject {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}
