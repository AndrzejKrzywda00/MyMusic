package JavaFX.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ArchivizeFromNetController {

    @FXML
    Button confirmButton;

    public void initialize() {

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
