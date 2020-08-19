package ch.fhnw.depa.mcsquanchy;

import javafx.scene.paint.Color;

public class ConcreteCommandA implements Command {
    private final Color rngColor;
    private final Receiver receiver;

    public ConcreteCommandA(Receiver r) {
        this.rngColor = Color.rgb((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255),1);
        this.receiver = r;
    }

    @Override
    public void execute() {
        receiver.setColor(this.rngColor);
    }

    @Override
    public void unexecute() {
        receiver.setColor(this.rngColor);
    }

    public String getColor() {
        return String.format("(%f, %f, %f)\n", this.rngColor.getRed(), this.rngColor.getGreen(), this.rngColor.getBlue());
    }
}
