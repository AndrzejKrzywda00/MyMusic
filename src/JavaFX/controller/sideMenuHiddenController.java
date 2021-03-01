package JavaFX.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class sideMenuHiddenController {

    ApplicationController windowsMediator = ApplicationController.getInstance();

    @FXML
    Button expandMenuButton;    // the only button - expands the menu o big one

    public void initialize() {

        expandMenuButton.setOnAction( e -> {
            windowsMediator.expandSideMenu();
        });

    }

    public sideMenuHiddenController() {
        windowsMediator.registerSideMenuHiddenController(this);
    }

}
