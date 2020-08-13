package ch.fhnw.depa.mcsquanchy.version1;

import javafx.scene.control.Label;

public class ConcreteObserver extends Label implements IObserver {
    private final ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject sub) {
        this.subject = sub;
        super.setText("0");
    }

    @Override
    public void update() {
        this.subject.getState();
        super.setText(Integer.toString(this.subject.getState()));
    }
}
