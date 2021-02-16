package JavaFX.controller;

import ClientApp.User;
import Interfaces.IControllable;
import enums.Phase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController implements IControllable {

    /* This class is the controller of the main widow of the application
    It sholud only manage graphic elements and take data from forms
    or display it
    All functionality related to data sholud be held in separate classes
     */

    // properties from .fxml file
    @FXML
    Button logOutButton;    // logs out user

    @FXML
    Button settingsButton;  // shows menu of settings

    @FXML
    Button statsButton;     // shows stats of user

    @FXML
    Button infoButton;      // directs to my page andrzejkrzywda.pl to show information or/and to github

    @FXML
    Button anonButton;      // for now i don't know what to put there

    @FXML
    ToggleButton themeButton;   // switches theme

    /* When user is not logged we can see only logging window, the main one is not visible
    When user is logged - logging one is invisible
     */
    private Phase phase;        // has two states - user is logged or user is not logged
    private Stage loginWindow;  // this is logging window and is owned via association by mainWindow
    private User user;          // this is user set to this instance of application

    ScreensContainer superController;

    public MainWindowController() {
        // warning - constructor must be public
        setScreenParent(superController);
    }

    void initialize() {
        // first formatting buttons

        EventHandler<ActionEvent> clickHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        };
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

    void formatMenuButtonsExpanded() {
        // formatting
    }

    // from IControllable
    @Override
    public void setScreenParent(ScreensContainer superController) {
        this.superController = superController;
    }
}
