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

    }

    public PlaylistsMenuController() {
        windowsMediator.registerPlaylistsController(this);
    }

}
