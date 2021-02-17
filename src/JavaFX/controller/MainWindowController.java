package JavaFX.controller;

import ClientApp.PhaseSynchronizer;
import ClientApp.User;
import Interfaces.IControllable;
import enums.Phase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import newTrackWindowConstants.DefaultValues;
import newTrackWindowConstants.ImagesPaths;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindowController implements IControllable {

    /* This class is the controller of the main widow of the application
    It sholud only manage graphic elements and take data from forms
    or display it
    All functionality related to data sholud be held in separate classes
     */

    // properties from .fxml file
    @FXML
    Button logOutButton;    // logs out user

    @FXML
    Button settingsButton;  // shows menu of settings

    @FXML
    Button statsButton;     // shows stats of user

    @FXML
    Button infoButton;      // directs to my page andrzejkrzywda.pl to show information or/and to github

    @FXML
    Button refreshButton;      // for now i don't know what to put there

    @FXML
    ToggleButton themeButton;   // switches theme

    @FXML
    VBox sideMenu;              // whole side menu

    @FXML
    AnchorPane baseAnchorPane;

    /* When user is not logged we can see only logging window, the main one is not visible
    When user is logged - logging one is invisible
     */
    private PhaseSynchronizer phaseSynchronizer;        // has two states - user is logged or user is not logged
    private User user;                                  // this is user set to this instance of application

    // having a parent - screen that contains of this window
    ScreensContainer superController;

    // const
    ImagesPaths paths = new ImagesPaths();
    DefaultValues values = new DefaultValues();

    public MainWindowController() {
        // warning - constructor must be public
        setScreenParent(superController);
        phaseSynchronizer = PhaseSynchronizer.getInstance();
    }

    @FXML
    void initialize() {
        // first formatting buttons
        paintButtonsDefault();
        formatMenuButtonsExpanded();

        EventHandler<ActionEvent> clickHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // identify the source and make apprioprate reaction
                if (event.getSource() == logOutButton) {
                    phaseSynchronizer.setNotLoggedPhase();
                    phaseSynchronizer.notifyObservers();
                }
            }
        };
        logOutButton.addEventHandler(ActionEvent.ACTION, clickHandler);

    }

    @FXML
    void logOutEntered() {
        logOutButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void logOutExited() {
        logOutButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    @FXML
    void settingsEntered() {
        settingsButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void settingsExited() {
        settingsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    @FXML
    void statsEntered() {
        statsButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void statsExited() {
        statsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    @FXML
    void infoEntered() {
        infoButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void infoExited() {
        infoButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    @FXML
    void refreshEntered() {
        refreshButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void refreshExited() {
        refreshButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    private void paintButtonsDefault() {
        logOutButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        settingsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        statsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        infoButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        refreshButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        themeButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    // adding method for setting other fxmls into main one
    public void setCenter(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        // accessing and bundling the resources
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException error) {
            error.printStackTrace();
        }
        // here add this to main pane via
        // ...Pane.setCenter(parent);
    }

    private void formatMenuButtonsExpanded() {
        // formatting buttons in expanded position
        // accessing images
        Image imageLogOut = new Image(paths.LOGOUT_IMAGE_PATH);
        Image imageSettings = new Image(paths.SETTINGS_IMAGE_PATH);
        Image imageStats = new Image(paths.STATS_IMAGE_PATH);
        Image imageWeb = new Image(paths.WEB_IMAGE_PATH);
        Image imageRefresh = new Image(paths.REFRESH_IMAGE_PATH);
        // adding them to list of ImageViews
        ImageView logOutButtonContent = new ImageView(imageLogOut);
        ImageView settingsButtonContent = new ImageView(imageSettings);
        ImageView statsButtonContent = new ImageView(imageStats);
        ImageView infoButtonContent = new ImageView(imageWeb);
        ImageView refreshButtonContent = new ImageView(imageRefresh);

        logOutButtonContent.setFitWidth(40);
        logOutButtonContent.setFitHeight(40);

        settingsButtonContent.setFitHeight(40);
        settingsButtonContent.setFitWidth(40);

        statsButtonContent.setFitWidth(40);
        statsButtonContent.setFitHeight(40);

        infoButtonContent.setFitHeight(35);
        infoButtonContent.setFitWidth(35);

        refreshButtonContent.setFitWidth(40);
        refreshButtonContent.setFitHeight(40);

        logOutButton.setGraphic(logOutButtonContent);
        settingsButton.setGraphic(settingsButtonContent);
        statsButton.setGraphic(statsButtonContent);
        infoButton.setGraphic(infoButtonContent);
        refreshButton.setGraphic(refreshButtonContent);
    }

    // from IControllable
    @Override
    public void setScreenParent(ScreensContainer superController) {
        this.superController = superController;
    }
}
