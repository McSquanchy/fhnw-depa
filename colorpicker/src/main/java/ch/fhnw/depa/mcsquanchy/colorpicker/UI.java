package ch.fhnw.depa.mcsquanchy.colorpicker;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class UI extends VBox {

    public UI(Model m) {
        MenuBar bar = new MenuBar();
        Menu menu = new Menu("File");
        MenuItem exit = new Menu("Exit");
        exit.setMnemonicParsing(true);
        exit.setOnAction(e -> Platform.exit());
        menu.getItems().add(exit);
        bar.getMenus().add(menu);

        this.setSpacing(10);

        GridPane mainUI = getGridPane(m);

        getChildren().addAll(bar, mainUI);
    }

    private GridPane getGridPane(Model m) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(0,10,10,10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label redLabel = new Label("R");
        TextField rgbRed = new TextField();
        TextField hexRgbRed = new TextField();
        hexRgbRed.textProperty().bindBidirectional(m.redHexStringProperty());
        hexRgbRed.textProperty().addListener((observable, oldValue, newValue) -> {
            int val = 0;
            try {
                val = Math.max(0, Math.min(255, Integer.parseInt(newValue, 16)));
            } catch(NumberFormatException e) {

            }
            m.redProperty().set(val);
        });
        rgbRed.textProperty().bindBidirectional(m.redProperty(), new NumberStringConverter());
        Slider redSlider = new Slider(0, 255,0);
        redSlider.valueProperty().bindBidirectional(m.redProperty());

        Label greenLabel = new Label("G");
        TextField rgbGreen = new TextField();
        TextField hexRgbGreen = new TextField();
        hexRgbGreen.textProperty().bind(m.greenHexStringProperty());
        rgbGreen.textProperty().bindBidirectional(m.greenProperty(), new NumberStringConverter());
        Slider greenSlider = new Slider(0, 255,0);
        greenSlider.valueProperty().bindBidirectional(m.greenProperty());

        Label blueLabel = new Label("B");
        TextField rgbBlue = new TextField();
        TextField hexRgbBlue = new TextField();
        hexRgbBlue.textProperty().bindBidirectional(m.blueHexStringProperty());
        rgbBlue.textProperty().bindBidirectional(m.blueProperty(), new NumberStringConverter());

        Slider blueSlider = new Slider(0, 255,0);
        blueSlider.valueProperty().bindBidirectional(m.blueProperty());

//        Label alphaLabel = new Label("A");
//        TextField rgbAlpha = new TextField();
//        rgbAlpha.textProperty().bindBidirectional(m.alphaProperty(), new NumberStringConverter());
//        Slider alphaSlider = new Slider(0, 1.0f,1.0f);
//        alphaSlider.valueProperty().bindBidirectional(m.alphaProperty());

        Rectangle display = new Rectangle();
        display.setHeight(100);
        display.setStroke(Color.BLACK);
        display.widthProperty().bind(pane.widthProperty().divide(3));
        display.fillProperty().bind(m.colorProperty());

        TextField rgbValCopyField = new TextField();
        Label rgbDecVal = new Label("RGB-Value");
        rgbValCopyField.textProperty().bindBidirectional(m.rgbDecValProperty());

        TextField rgbHexValCopyField = new TextField();
        Label rgbHexVal = new Label("Hex-Value");
        rgbHexValCopyField.textProperty().bindBidirectional(m.rgbHexValProperty());

        pane.add(redLabel, 0,0,1,1);
        pane.add(redSlider, 1,0,1,1);
        pane.add(rgbRed,2,0,1,1);
        pane.add(hexRgbRed, 3,0,1,1);

        pane.add(greenLabel, 0,1,1,1);
        pane.add(greenSlider,1,1,1,1);
        pane.add(rgbGreen, 2,1,1,1);
        pane.add(hexRgbGreen, 3,1,1,1);

        pane.add(blueLabel,0,2,1,1);
        pane.add(blueSlider,1,2,1,1);
        pane.add(rgbBlue, 2,2,1,1);
        pane.add(hexRgbBlue, 3,2,1,1);

//        pane.add(alphaLabel, 0,3,1,1);
//        pane.add(alphaSlider, 1,3,1,1);
//        pane.add(rgbAlpha,2,3,1,1);

        pane.add(display, 0,4, 3,2);

        pane.add(rgbValCopyField, 2,5,1,1);
        pane.add(rgbDecVal, 2,4,1,1);

        pane.add(rgbHexValCopyField, 3,5,1,1);
        pane.add(rgbHexVal, 3,4,1,1);
        return pane;
    }
}
