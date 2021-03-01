package JavaFX.controller;

import App.PhaseSynchronizer;
import App.User;
import Interfaces.IControllable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import newTrackWindowConstants.DefaultValues;
import newTrackWindowConstants.ImagesPaths;
import newTrackWindowConstants.ScreensPaths;

import java.util.HashMap;
import java.util.Map;

public class MainWindowController implements IControllable {

    /* This class is the controller of the main widow of the application
    It sholud only manage graphic elements and take data from forms
    or display it
    All functionality related to data sholud be held in separate classes
     */

    // functional buttons
    @FXML
    Button addTrackButton;              // loads the addTrack fxml file

    @FXML
    Button removeTrackButton;           // loads the removeTrack fxml file

    @FXML
    Button createPlaylistButton;        // opens menu for adding files to a playlist

    @FXML
    AnchorPane buildPane;               // main container of the app

    @FXML
    Pane sideMenuBuildPane;             // container for side menus - hidden and expanded

    /* When user is not logged we can see only logging window, the main one is not visible
    When user is logged - logging one is invisible
     */
    private ApplicationController windowsMediator;        // class responsible for coummunication between separate controllers
    private PhaseSynchronizer phaseSynchronizer;        // has two states - user is logged or user is not logged
    private User user;                                  // this is user set to this instance of application

    // having a parent - screen that contains of this window
    ScreensContainer superController;

    // const
    ImagesPaths imagesPaths = new ImagesPaths();
    DefaultValues values = new DefaultValues();
    ScreensPaths screensPaths = new ScreensPaths();

    // screens to be loaded with their names
    private HashMap<String, Node> elements = new HashMap<String, Node>();
    private Node mainContent;

    public MainWindowController() {

        // setting screen parent for purposes of general login-main window sych
        setScreenParent(superController);
        phaseSynchronizer = PhaseSynchronizer.getInstance();

        windowsMediator = ApplicationController.getInstance();    // getting instance

        // [ screen1 ], [ screen2 ], [ screen3 ], ...
        // loading all possible screens to this form
        loadScreens();
    }

    @FXML
    void initialize() {

        windowsMediator.registerMainWindowController(this);       // registering myself to call my methods

        // saving main screen
        try {
            mainContent = buildPane.getChildren().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // side screen is loaded by default
        setSideScreen(screensPaths.SideMenuExpanded);

        // add new track button is clicked
        addTrackButton.setOnAction( e -> {
            // switch the content to add new track form
            setScreen(screensPaths.AddNewTrackScreen);
        });

        // remove track button is clicked
        removeTrackButton.setOnAction( e -> {
            setScreen(screensPaths.TrackListScreen);
        });

        createPlaylistButton.setOnAction( e -> {
            setScreen(screensPaths.PlaylistScreen);
        });
    }

    /***
     * Displays the demanded screen on top
     * @param name of the screen to be displayed
     */
    private void setScreen(String name) {

        if (elements.containsKey(name)) {
            Node screen = elements.get(name);
            if(!buildPane.getChildren().isEmpty()) {
                buildPane.getChildren().remove(0);
                buildPane.getChildren().add(0, screen);
            }
            else  {
                buildPane.getChildren().add(screen);
            }
        }
    }

    /***
     * This method loads element from the path provided
     * @param fxmlPath  path to file .fxml
     * @return  loaded element of type Parent
     */
    private void loadScreens() {

        for (Map.Entry<String,String> screen : screensPaths.screens.entrySet()) {
            String name = screen.getKey();          // name of screen
            String fxmlPath = screen.getValue();    // value - path to fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent parent = null;
            try {
                parent = (Parent) loader.load();
            } catch (Exception e ) {
                e.printStackTrace();
            }
            elements.put(name, parent);             // putting pair <name, node> into loaded hash map
        }
    }

    private void setSideScreen(String name) {
        if (elements.containsKey(name)) {
            Node sideScreen = elements.get(name);
            if (!sideMenuBuildPane.getChildren().isEmpty()) {
                sideMenuBuildPane.getChildren().remove(0);
                sideMenuBuildPane.getChildren().add(sideScreen);
            }
            else {
                sideMenuBuildPane.getChildren().add(sideScreen);
            }
        }
    }

    public void expandSideMenu() {
        setSideScreen(screensPaths.SideMenuExpanded);
    }

    public void hideSideMenu() {
        setSideScreen(screensPaths.SideMenuHidden);
    }

    public void resetScreen() {
        if (mainContent != null) {
            if (!buildPane.getChildren().isEmpty()) {
                buildPane.getChildren().set(0, mainContent);
            }
            else {
                buildPane.getChildren().add(mainContent);
            }
        }
    }

    // from IControllable
    @Override
    public void setScreenParent(ScreensContainer superController) {
        this.superController = superController;
    }

}
