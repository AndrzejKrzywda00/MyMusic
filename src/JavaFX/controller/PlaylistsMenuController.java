package JavaFX.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PlaylistsMenuController {

    /*
    This is a controller class for a playlists menu
     */

    ApplicationController windowsMediator = ApplicationController.getInstance();

    @FXML
    TextField titleTextField;

    @FXML
    TextField descriptionTextField;

    @FXML
    Button addThumbnailButton;

    @FXML
    Button cancelButton;

    @FXML
    Button confirmButton;

    @FXML
    Button exitButton;

    public void initialize() {

        exitButton.setOnAction( e -> {
            windowsMediator.mainWindowSetToDefault();
        });

        confirmButton.setOnAction( e -> {
            // approve data
        });

    }

    public PlaylistsMenuController() {
        windowsMediator.registerPlaylistsController(this);
    }

    @FXML
    public void confirmButtonEntered() {
        confirmButton.setStyle("-fx-background-color: rgb(20, 245, 80);");
    }

    @FXML
    public void confirmButtonExited() {
        confirmButton.setStyle("-fx-background-color: rgb(2, 222, 61);");
    }

    @FXML
    public void cancelButtonEntered() {
        cancelButton.setStyle("-fx-background-color: rgb(252, 47, 33);");
    }

    @FXML
    public void cancelButtonExited() {
        cancelButton.setStyle("-fx-background-color: rgb(237, 27, 12);");
    }

}
