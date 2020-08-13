package ch.fhnw.depa.mcsquanchy.version1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Observer-Pattern-Version1");

        ConcreteSubject s = new ConcreteSubject();
        ConcreteObserver firstObserver = new ConcreteObserver(s);
        ConcreteObserver secondObserver = new ConcreteObserver(s);
        ConcreteObserver thirdObserver = new ConcreteObserver(s);
        s.addObserver(firstObserver);
        s.addObserver(secondObserver);
        s.addObserver(thirdObserver);

        Button btn = new Button();
        btn.setText("Trigger Update");
        btn.setOnAction(event -> {
            s.setState();
            s.notifyObservers();
        });

        StackPane root = new StackPane();
        root.setPadding(new Insets(20));
        root.getChildren().addAll(btn, firstObserver, secondObserver, thirdObserver);
        StackPane.setAlignment(btn, Pos.TOP_CENTER);
        StackPane.setAlignment(firstObserver, Pos.CENTER_LEFT);
        StackPane.setAlignment(secondObserver, Pos.CENTER);
        StackPane.setAlignment(thirdObserver, Pos.CENTER_RIGHT);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
