package JavaFX.controller;

import App.ID;
import App.PhaseSynchronizer;
import App.User;
import Interfaces.IControllable;
import Interfaces.IObservable;
import Interfaces.IObserver;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import newTrackWindowConstants.ImagesPaths;

import java.util.ArrayList;

public class sideMenuExpandedController {

    // data
    ImagesPaths imagesPaths = new ImagesPaths();

    // synchronization for changing stages
    PhaseSynchronizer phaseSynchronizer = PhaseSynchronizer.getInstance();

    // instance of windowsMediator
    ApplicationController windowsMediator = ApplicationController.getInstance();

    // user - it's there - because it's displayed here
    private User user = new User();

    /*
    This class is the controller of actions of side menu
     */

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
    Label userRealNameLabel;    // choosen name in registration

    @FXML
    Label userNameLabel;        // username used in registration

    @FXML
    Button wrapMenuButton;      // topmost button to wrap the side menu

    public sideMenuExpandedController() {
        windowsMediator.registerSideMenuExpandedController(this);
    }


    public void initialize() {

        formatMenuButtons();
        paintButtonsDefault();

        logOutButton.setOnAction( e -> {
            phaseSynchronizer.setNotLoggedPhase();  // makes the deal work
        });

        wrapMenuButton.setOnAction( e -> {
            windowsMediator.wrapSideMenu();
        });

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

    @FXML
    void themeEntered() {
        themeButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void themeExited() {
        themeButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    private void paintButtonsDefault() {
        logOutButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        settingsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        statsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        infoButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        refreshButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        themeButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    private void formatMenuButtons() {
        // formatting buttons in expanded position
        // accessing images
        Image imageLogOut = new Image(imagesPaths.LOGOUT_IMAGE_PATH);
        Image imageSettings = new Image(imagesPaths.SETTINGS_IMAGE_PATH);
        Image imageStats = new Image(imagesPaths.STATS_IMAGE_PATH);
        Image imageWeb = new Image(imagesPaths.WEB_IMAGE_PATH);
        Image imageRefresh = new Image(imagesPaths.REFRESH_IMAGE_PATH);
        Image imageBrightMode = new Image(imagesPaths.BRIGHT_IMAGE_PATH);
        Image imageBack = new Image(imagesPaths.GO_BACK_ARROW_IMAGE_PATH);

        // adding them to list of ImageViews
        ImageView logOutButtonContent = new ImageView(imageLogOut);
        ImageView settingsButtonContent = new ImageView(imageSettings);
        ImageView statsButtonContent = new ImageView(imageStats);
        ImageView infoButtonContent = new ImageView(imageWeb);
        ImageView refreshButtonContent = new ImageView(imageRefresh);
        ImageView modeButtonContent = new ImageView(imageBrightMode);
        ImageView wrapMenuContent = new ImageView(imageBack);

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

        modeButtonContent.setFitHeight(40);
        modeButtonContent.setFitWidth(40);

        wrapMenuContent.setFitWidth(35);
        wrapMenuContent.setFitHeight(40);
        wrapMenuContent.setScaleY(-1.0);  // mirror view so basically we go from <| to |>

        // setting up the images
        logOutButton.setGraphic(logOutButtonContent);
        settingsButton.setGraphic(settingsButtonContent);
        statsButton.setGraphic(statsButtonContent);
        infoButton.setGraphic(infoButtonContent);
        refreshButton.setGraphic(refreshButtonContent);
        themeButton.setGraphic(modeButtonContent);
        wrapMenuButton.setGraphic(wrapMenuContent);
    }

}
