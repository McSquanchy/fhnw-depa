package ch.fhnw.depa.mcsquanchy;

public class Leaf implements Component {
    String text;

    public Leaf(String text) {
        this.text = text;
    }

    @Override
    public String getHtml() {
        return this.text;
    }
}
