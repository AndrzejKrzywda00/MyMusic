package JavaFX.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class ArchivizeFromNetController {

    // mediator
    ApplicationController windowsMediator = ApplicationController.getInstance();

    @FXML
    TextField titleTextField;

    @FXML
    TextField serviceTextField;

    @FXML
    TextField timeTextField;

    @FXML
    TextField amountOfTracksTextField;

    @FXML
    TextField accessTextField;

    @FXML
    Button confirmButton;

    @FXML
    Button loadPlaylistButton;

    @FXML
    Button exitButton;

    public void initialize() {

        formatButtonsDefault();

        confirmButton.setOnAction( e -> {
            // validate
        });

        loadPlaylistButton.setOnAction( e -> {
            // prepare download from api of certain application
        });

        exitButton.setOnAction( e -> {
            // load main window
            windowsMediator.mainWindowSetToDefault();
        });

    }

    public ArchivizeFromNetController() {
        windowsMediator.registerArchivizeFromNetController(this);
    }

    @FXML
    public void confirmButtonEntered() {
        confirmButton.setStyle("-fx-background-color:  black; " + "-fx-text-fill: white;");
    }

    @FXML
    public void confirmButtonExited() {
        confirmButton.setStyle("-fx-background-color:  white; " + "fx-text-fill: black; " + "-fx-border-color: black;");
    }

    @FXML
    public void loadPlaylistButtonEntered() {
        loadPlaylistButton.setStyle("-fx-background-color:  black; " + "-fx-text-fill: white;");
    }

    @FXML
    public void loadPlaylistButtonExited() {
        loadPlaylistButton.setStyle("-fx-background-color:  white; " + "fx-text-fill: black; " + "-fx-border-color: black;");
    }

    private void formatButtonsDefault() {
        confirmButton.setStyle("-fx-background-color:  white; " + "fx-text-fill: black; " + "-fx-border-color: black;");
        loadPlaylistButton.setStyle("-fx-background-color:  white; " + "fx-text-fill: black; " + "-fx-border-color: black;");
    }

}
