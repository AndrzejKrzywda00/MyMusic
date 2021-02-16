package JavaFX.controller;

import Interfaces.IControllable;
import MyExceptions.ScreenNotLoadedException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import javax.imageio.plugins.tiff.ExifParentTIFFTagSet;
import java.io.IOException;
import java.security.Key;
import java.util.HashMap;

public class ScreensController extends StackPane {

    // ScreensController class IS the controller of controllers
    // it sychronizes changes between what the user will see in the runtime
    // of the application

    // Holds the screens to be displayed
    /*
    There screens can be accessed via their names like
    "add new track screen" : AddTrackMenu.fxml
     */
    private HashMap<String, Node> screens = new HashMap<String, Node>();

    public ScreensController() {
        super();    // starting the StackPane
    }

    // adding a screen to collection
    public void addScreen(String name, Node screen)  {
        screens.put(name, screen);
    }

    // getter for screens
    public Node getScreen(String name) {
        return screens.get(name);
    }

    // Loads the .fxml file, adds the screen to the screens collection
    // and finally injects the screenPane to the controller

    /***
     *
     * @param name      Name of the screen - this is ID
     * @param resource  a path to fxml file
     * @return          true if operation has been sucessfull, otherwise false if exception occured
     */
    public Boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) loader.load();
            IControllable localController = (IControllable) loader.getController();
            localController.setScreenParent(this);  // letting know controller of the new window that this class is a parent
            addScreen(name, loadScreen);        // adding a new screen to collection
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /***
     *
     * @param name Takes the name - id of the screen we want to load
     * @return  true if screen has been set successfully, false otherwise
     * @throws ScreenNotLoadedException when screen hasn't been loaded prevously
     */
    public Boolean setScreen(final String name) throws ScreenNotLoadedException {
        if (screens.get(name) != null) {                        // there exist such screen loaded
            final DoubleProperty opacity = opacityProperty();   // taking the opacity property of this
            Node newScreen = screens.get(name);                 // the screen we are adding
            if (!getChildren().isEmpty()) {                     // we have more than one screen
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                getChildren().remove(0);            // removing current screen that is displayed
                                getChildren().add(0, newScreen);    // adding the selected screen
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                                        new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();
            } else {
                setOpacity(0.0);    // main stack pane is not to be visible at any moment
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            //throw new ScreenNotLoadedException("Screen hasn't been loaded");
            return false;
        }
    }

    public Boolean uloadScreen(String name) {
        if (screens.remove(name) == null) {     // both doing the operation and checking if successfull
            System.out.println("Screen didn't exist");
            return false;
        }
        else {
            return true;
        }
    }

}
