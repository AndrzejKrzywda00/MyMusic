package JavaFX.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class sideMenuController {

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


    void initialize() {

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

}
