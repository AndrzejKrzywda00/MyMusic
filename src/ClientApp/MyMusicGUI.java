/*
Application My Music
@author Andrzej Krzywda
Date : February 2021
Release : 1.0.0
 */

package ClientApp;

import Interfaces.IObservable;
import Interfaces.IObserver;
import JavaFX.controller.ScreensContainer;
import enums.Phase;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MyMusicGUI extends Application implements IObserver {

    /* I think this class sholud only sychronize and manage changes
    * All the functioanlity will be moved to functional
    * objects, instances of which will be kept here
    * */

    // constant data for this class
    public static final String MAIN_WINDOW_FXML_PATH = "/FXMLfiles/mainWindowSource.fxml";
    public static final String LOGIN_WINDOW_FXML_PATH = "/FXMLfiles/loginWindowSource.fxml";

    // names of the windows
    public static final String loginWindowName = "loginWindow";
    public static final String mainWindowName = "mainWindow";

    // properties
    // an instance of PhaseSynchronizer is created to cope with phases
    PhaseSynchronizer phaseSynchronizer = PhaseSynchronizer.getInstance();

    // user of instance of application - one's data is downloaded from server
    User user;

    // master container, that loads screens in the special sequence
    ScreensContainer mainContainer = new ScreensContainer();

    // Stage
    Stage primaryStage = new Stage();

    // contructor
    public MyMusicGUI() {
        phaseSynchronizer.add(this);    // adding this class as subscriber to PhaseSychronizer <- MyMusicGUI
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        this.primaryStage = primaryStage;

        mainContainer.loadScreen(loginWindowName, LOGIN_WINDOW_FXML_PATH);
        mainContainer.loadScreen(mainWindowName, MAIN_WINDOW_FXML_PATH);

        // setting which screen i want to display
        mainContainer.setScreen(loginWindowName);

        Image icon = new Image("logoMyMusicSmall.png");     //resource must be 32x32 or smaller but 64x64 is too big
        this.primaryStage.getIcons().add(icon);

        this.primaryStage.setTitle("MyMusic - logowanie");

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();

    }

    // this method satisfies the IObserver interface
    @Override
    public void update() {
        // we need to check the state of phaseSychronizer
        if (phaseSynchronizer.getPhase() == Phase.NotLogged) {
            setScreenToLogin();
        }
        if (phaseSynchronizer.getPhase() == Phase.Logged) {
            setScreenToMain();
        }
    }

    // This function calls setScreen method on mainContainer
    // but also adds some specific configuration to primaryStages
    public void setScreenToMain() {
        mainContainer.setScreen(mainWindowName);
        // formating primaryStage
        primaryStage.setTitle("Aplikacja do archiwizacji muzyki - MyMusic");    // adding some description
        primaryStage.setMaximized(true);        // main window will always be maximized

    }

    public void setScreenToLogin() {
        /*
        Size of the login window is 603 x 676 and should be centered
         */
        mainContainer.setScreen(loginWindowName);
        this.primaryStage.setTitle("MyMusic - logowanie");      // adding some description
        this.primaryStage.setMaximized(false);
    }
}
