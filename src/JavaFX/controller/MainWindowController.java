package JavaFX.controller;

import ClientApp.User;
import enums.Phase;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MainWindowController {

    /* This class is the controller of the main widow of the application
    It sholud only manage graphic elements and take data from forms
    or display it
    All functionality related to data sholud be held in separate classes
     */

    // properties

    /* When user is not logged we can see only logging window, the main one is not visible
    When user is logged - logging one is invisible
     */
    private Phase phase;        // has two states - user is logged or user is not logged
    private Stage loginWindow;  // this is logging window and is owned via association by mainWindow
    private User user;          // this is user set to this instance of application

    public MainWindowController() {
        // warning - constructor must be public
    }

    void initialize() {

    }

    // adding method for setting other fxmls into main one
    public void setCenter(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        // accessing and bundling the resources
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException error) {
            error.printStackTrace();
        }
        // here add this to main pane via
        // ...Pane.setCenter(parent);
    }

}
