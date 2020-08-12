package ch.fhnw.depa.mcsquanchy.colorpicker;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;

public class Model {

    private final SimpleIntegerProperty red = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty green = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty blue = new SimpleIntegerProperty(0);
    private final SimpleFloatProperty alpha = new SimpleFloatProperty(1.0f);

    private final ObjectProperty<Color> color = new SimpleObjectProperty<>(Color.BLACK);

    DecimalFormat df = new DecimalFormat();

    private final SimpleStringProperty rgbDecVal;
    private final SimpleStringProperty rgbHexVal;
    private final SimpleStringProperty redHexString;
    private final SimpleStringProperty greenHexString;
    private final SimpleStringProperty blueHexString;

    public Model() {
        df.setMaximumFractionDigits(3);
        rgbHexVal = new ReadOnlyStringWrapper(Integer.toString(getRed(), 16) + Integer.toString(getGreen(), 16) + Integer.toString(getBlue(), 16) + "000");
        rgbDecVal = new ReadOnlyStringWrapper("(" + getRed() + ", " + getGreen() + ", " + getBlue() + ", " + df.format(getAlpha()) + ")");
        redHexString = new SimpleStringProperty(Integer.toString(red.getValue(), 16).toUpperCase());
        greenHexString = new SimpleStringProperty(Integer.toString(green.getValue(), 16).toUpperCase());
        blueHexString = new SimpleStringProperty(Integer.toString(blue.getValue(), 16).toUpperCase());

        red.addListener((observable, oldValue, newValue) -> {
            int val = Math.max(0, Math.min(255, newValue.intValue()));
            color.set(Color.rgb(val, getGreen(), getBlue(), getAlpha()));
            updateRgbString();
            updateHexString("r");
        });
        green.addListener((observable, oldValue, newValue) -> {
            int val = Math.max(0, Math.min(255, newValue.intValue()));
            color.set(Color.rgb(getRed(), val, getBlue(), getAlpha()));
            updateRgbString();
            updateHexString("g");
        });
        blue.addListener((observable, oldValue, newValue) -> {
            int val = Math.max(0, Math.min(255, newValue.intValue()));
            color.set(Color.rgb(getRed(), getGreen(), val, getAlpha()));
            updateRgbString();
            updateHexString("b");
        });
        alpha.addListener((observable, oldValue, newValue) -> {
            float val = Math.max(0.0f, Math.min(1.0f, newValue.floatValue()));
            color.set(Color.rgb(getRed(), getGreen(), getBlue(), val));
            updateRgbString();
        });
    }

    private void updateHexString(String s) {
        if("r".equals(s)) {
            redHexString.set(Integer.toString(red.getValue(), 16).length() == 1 ? Integer.toString(red.getValue(), 16).toUpperCase() + "0" : Integer.toString(red.getValue(), 16).toUpperCase());
        } else if ("g".equals(s)) {
            greenHexString.set(Integer.toString(green.getValue(), 16).length() == 1 ? Integer.toString(green.getValue(), 16).toUpperCase() + "0" : Integer.toString(green.getValue(), 16).toUpperCase());
        } else {
            blueHexString.set(Integer.toString(green.getValue(), 16).length() == 1 ? Integer.toString(green.getValue(), 16).toUpperCase() + "0" : Integer.toString(green.getValue(), 16).toUpperCase());
        }
    }

    private void updateRgbString() {
        rgbDecVal.set("(" + getRed() + ", " + getGreen() + ", " + getBlue() + ", " + df.format(getAlpha()) + ")");
        rgbHexVal.set(Integer.toString(getRed(), 16).toUpperCase() + Integer.toString(getGreen(), 16).toUpperCase() + Integer.toString(getBlue(), 16).toUpperCase());
    }

    public int getRed() {
        return red.get();
    }

    public SimpleIntegerProperty redProperty() {
        return red;
    }

    public int getGreen() {
        return green.get();
    }

    public SimpleIntegerProperty greenProperty() {
        return green;
    }

    public int getBlue() {
        return blue.get();
    }

    public SimpleIntegerProperty blueProperty() {
        return blue;
    }

    public SimpleFloatProperty alphaProperty() {
        return alpha;
    }

    public float getAlpha() {
        return alpha.get();
    }

    public SimpleStringProperty redHexStringProperty() {
        return redHexString;
    }

    public String getGreenHexString() {
        return greenHexString.get();
    }

    public SimpleStringProperty greenHexStringProperty() {
        return greenHexString;
    }

    public String getBlueHexString() {
        return blueHexString.get();
    }

    public SimpleStringProperty blueHexStringProperty() {
        return blueHexString;
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public String getRgbDecVal() {
        return rgbDecVal.get();
    }

    public SimpleStringProperty rgbDecValProperty() {
        return rgbDecVal;
    }

    public String getRgbHexVal() {
        return rgbHexVal.get();
    }

    public SimpleStringProperty rgbHexValProperty() {
        return rgbHexVal;
    }


    public String getRedHexString() {
        return redHexString.get();
    }
}
