package JavaFX.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;

public class StackPaneController {

    // This class will be automatically initialised when loader is called in MyMusicGUI

    // This button will be auto-initialised after calling initialize() and there is no need to instantiate it
    @FXML
    private Button button;

    public StackPaneController() {
        // For now nothing here
    }

    @FXML
    void initialize() {
        // All starting configuration
    }

    /*
    @FXML   // WARNING -- remember about importing right package!
    public void mouseEntered(MouseEvent e) {
        // Args let us take more data from running app
        System.out.println("najechano na przycisk -- " + e.toString() );
    }
     */

    @FXML
    public void buttonClicked(ActionEvent e) {
        System.out.println("Naciśnięto przycisk -- " + e.getSource());
        if (e.getSource() instanceof CheckBox) {
            // we can check the actual source of overriden function in fxml editor
        }
    }
}
