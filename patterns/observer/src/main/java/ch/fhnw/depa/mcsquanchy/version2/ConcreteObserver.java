package ch.fhnw.depa.mcsquanchy.version2;

import javafx.scene.control.Label;

public class ConcreteObserver extends Label implements IObserver {
    private final ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject sub) {
        this.subject = sub;
        super.setText("0");
    }

    @Override
    public void update(int newState) {
        super.setText(Integer.toString((newState)));
    }
}
