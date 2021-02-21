package JavaFX.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class sideMenuHiddenController {

    @FXML
    Button expandMenuButton;    // the only button - expands the menu o big one

    void initialize() {

        expandMenuButton.setOnAction( e -> {
            // load the expanded one
        });

    }

}
