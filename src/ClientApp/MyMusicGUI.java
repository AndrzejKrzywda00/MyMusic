/*
Application My Music
@author Andrzej Krzywda
Date : February 2021
Release : 1.0.0
 */

package ClientApp;

import JavaFX.controller.ScreensContainer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MyMusicGUI extends Application {

    /* I think this class sholud only sychronize and manage changes
    * All the functioanlity will be moved to functional
    * objects, instances of which will be kept here
    * */

    // constant data for this class
    public static final String MAIN_WINDOW_FXML_PATH = "/FXMLfiles/mainWindowSource.fxml";
    public static final String LOGIN_WINDOW_FXML_PATH = "/FXMLfiles/loginWindowSource.fxml";
    public static final String ADD_TRACK_MENU_FXML_PATH = "/FXMLfiles/addTrackMenu.fxml";

    // names of the windows
    public static final String loginWindowName = "loginWindow";
    public static final String mainWindowName = "mainWindow";

    // properties
    PhaseSynchronizer phaseSynchronizer = PhaseSynchronizer.getInstance();    // an instance of PhaseSynchronizer is created to cope with phases

    // user of instance of application - one's data is downloaded from server
    User user;


    // contructor
    public MyMusicGUI() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException{


        // master controller, that manages changes in controllers
        ScreensContainer mainContainer = new ScreensContainer();
        mainContainer.loadScreen(loginWindowName, LOGIN_WINDOW_FXML_PATH);
        mainContainer.loadScreen(mainWindowName, MAIN_WINDOW_FXML_PATH);

        // setting which screen i want to display
        mainContainer.setScreen(loginWindowName);

        Image icon = new Image("logoMyMusicSmall.png");     //resource must be 32x32 or smaller but 64x64 is too big
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("MyMusic - logowanie");

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        /*

        // Importing info from .fxml file
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

        Scene scene = new Scene(stackPane);

        MainWindowController controller = loader.getController();
        primaryStage.setScene(scene);

        // global config of the app
        // this is primary stage of the application and here
        // will be held the main functionality
        // It will start some child windows

        Image icon = new Image("logoMyMusicSmall.png");     //resource must be 32x32 or smaller but 64x64 is too big
        primaryStage.sizeToScene();
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("MyMusic");
        primaryStage.setMaximized(true);
        //primaryStage.show();

        // generating logging window
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource(LOGIN_WINDOW_FXML_PATH));
        StackPane loginPane = loginLoader.load();
        Stage loggingStage = new Stage();
        Scene logingScene = new Scene(loginPane);
        loggingStage.setScene(logingScene);
        loggingStage.sizeToScene();
        loggingStage.getIcons().add(icon);
        loggingStage.setTitle("Zaloguj do MyMusic");
        loggingStage.show();


         */

        // one window can be visible at a time
        // TODO - write automatic synchronization of visibility of windows
    }

}
