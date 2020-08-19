package ch.fhnw.depa.mcsquanchy;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Receiver extends Rectangle {

        public Receiver() {
            this.setWidth(200);
            this.setHeight(80);
            this.setFill(new Color(0,0,0,1));
        }

        public void setColor(Color c) {
            this.setFill(c);
        }

}
