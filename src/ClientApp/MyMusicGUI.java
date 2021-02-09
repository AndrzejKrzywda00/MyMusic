package ClientApp;

import JavaFX.controller.StackPaneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MyMusicGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        /* Importing info from .fxml file */
        // It describes all layout of the application
        FXMLLoader loader = new FXMLLoader();

        // File is in 'FXML files' package
        // TODO -- add proper handling of IOException -- checking if fxml exists and is proper type
        // probably use 'try' on all code
        loader.setLocation(this.getClass().getResource("/FXMLfiles/loginWindowSource.fxml"));

        StackPane stackPane = loader.load();

        StackPaneController controller = loader.getController();
        Scene scene = new Scene(stackPane);

        primaryStage.setScene(scene);

        // global config of the app
        /* this is primary stage of the application and here
        will be held the main functionality
        It will start some child windows
         */
        primaryStage.getIcons().add( new Image("file:../res/logoMyMusic.ico"));     // it doesn't work for now
        primaryStage.setTitle("MyMusic");
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
