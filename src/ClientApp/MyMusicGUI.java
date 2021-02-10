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
        loader.setLocation(this.getClass().getResource("/FXMLfiles/mainWindowSource.fxml"));

        StackPane stackPane = loader.load();

        StackPaneController controller = loader.getController();
        Scene scene = new Scene(stackPane,1920,1080);

        primaryStage.setScene(scene);

        // global config of the app
        /* this is primary stage of the application and here
        will be held the main functionality
        It will start some child windows
         */
        Image icon = new Image("logoMyMusicSmall.png"); //resource must be 32x32 or smaller but 64x64 is too big
        primaryStage.sizeToScene();
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("MyMusic");
        primaryStage.setMaximized(true);
        primaryStage.show();

        
    }
}
