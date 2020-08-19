package ch.fhnw.depa.mcsquanchy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Command Pattern");

        Receiver rec = new Receiver();
        Invoker invoker = new Invoker(new ConcreteCommandA(rec));

        Button onBtn = new Button();
        Button undoBtn = new Button();
        Button redoBtn = new Button();

        onBtn.setText("Randomize Color");
        onBtn.setOnAction(e -> {
            ConcreteCommandA cmd = new ConcreteCommandA(rec);
            invoker.setCommand(cmd);
        });

        undoBtn.setText("Undo");
        undoBtn.setOnAction(e -> invoker.undo());

        redoBtn.setText("Redo");
        redoBtn.setOnAction(e -> invoker.redo());

        StackPane root = new StackPane();
        root.getChildren().addAll(onBtn, undoBtn, redoBtn, rec);
        StackPane.setAlignment(rec, Pos.TOP_CENTER);
        StackPane.setAlignment(undoBtn, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(redoBtn, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(onBtn, Pos.CENTER);
        root.setPadding(new Insets(20));
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}