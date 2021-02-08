package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class MyMusicGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
        primaryStage.setTitle("MyMusic");
    }
}
