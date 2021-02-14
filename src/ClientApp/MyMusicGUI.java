/*
Application My Music
Developed by Andrzej Krzywda
Date : February 2021
Release : 1.0.0
 */

package ClientApp;

import JavaFX.controller.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MyMusicGUI extends Application {

    /* I think this class sholud only sychronize and manage changes
    * All the functioanlity will be moved to functional
    * objects, instances of which will be kept here
    * */

    // properties
    PhaseSynchronizer phaseSynch = PhaseSynchronizer.getInstance();    // an instance of PhaseSynchronizer is created to cope with phases

    User user;  // user of instance of application - one's data is downloaded from server

    // constant data for this class
    public static final String MAIN_WINDOW_FXML_PATH = "/FXMLfiles/mainWindowSource.fxml";
    public static final String LOGIN_WINDOW_FXML_PATH = "/FXMLfiles/loginWindowSource.fxml";
    public static final String ADD_TRACK_MENU_FXML_PATH = "/FXMLfiles/addTrackMenu.fxml";


    // contructor
    public MyMusicGUI() {
    }

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
        loader.setLocation(this.getClass().getResource(MAIN_WINDOW_FXML_PATH));

        StackPane stackPane = null;
        
        try {
            stackPane = loader.load();  // this throws IOException if there is problem in fxml file
        } catch (IOException error) {
            error.printStackTrace();
        }

        MainWindowController controller = loader.getController();
        Scene scene = new Scene(stackPane);

        primaryStage.setScene(scene);

        // global config of the app
        /* this is primary stage of the application and here
        will be held the main functionality
        It will start some child windows
         */
        Image icon = new Image("logoMyMusicSmall.png");     //resource must be 32x32 or smaller but 64x64 is too big
        primaryStage.sizeToScene();
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("MyMusic");
        primaryStage.setMaximized(true);
        //primaryStage.show();

        // generating logging window
        Stage loggingStage = new Stage();
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource(ADD_TRACK_MENU_FXML_PATH));
        StackPane loginPane = loginLoader.load();
        Scene logingScene = new Scene(loginPane);
        loggingStage.setScene(logingScene);
        loggingStage.sizeToScene();
        loggingStage.getIcons().add(icon);
        loggingStage.setTitle("Zaloguj do MyMusic");
        loggingStage.show();

        // one window can be visible at a time
        // TODO - write automatic synchronization of viisibility of windows

        

    }
}
