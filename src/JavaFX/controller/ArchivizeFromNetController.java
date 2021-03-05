package JavaFX.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ArchivizeFromNetController {

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

    public void initialize() {

        confirmButton.setOnAction( e -> {
            // validate
        });

    }

    public ArchivizeFromNetController() {

    }

    @FXML
    public void confirmButtonEntered() {
        confirmButton.setStyle("-fx-background-color:  rgb(2, 222, 61)");
    }

    @FXML
    public void confirmButtonExited() {
        confirmButton.setStyle("-fx-background-color:  rgb(20, 245, 80)");
    }

}
