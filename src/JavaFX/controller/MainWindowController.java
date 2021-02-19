package JavaFX.controller;

import ClientApp.PhaseSynchronizer;
import ClientApp.User;
import Interfaces.IControllable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    Button refreshButton;      // for now i don't know what to put there

    @FXML
    ToggleButton themeButton;   // switches theme


    // functional buttons
    @FXML
    Button addTrackButton;      // loads the addTrack fxml file

    @FXML
    Button removeTrackButton;   // loads the removeTrack fxml file

    @FXML
    Button createPlaylistButton;    // opens menu for adding files to a playlist

    @FXML
    VBox sideMenu;              // whole side menu

    @FXML
    ScrollPane sideMenuScrollPane;      // container for vbox

    @FXML
    AnchorPane buildPane;                // main container of the app

    /* When user is not logged we can see only logging window, the main one is not visible
    When user is logged - logging one is invisible
     */
    private PhaseSynchronizer phaseSynchronizer;        // has two states - user is logged or user is not logged
    private User user;                                  // this is user set to this instance of application

    // having a parent - screen that contains of this window
    ScreensContainer superController;

    // const
    ImagesPaths imagesPaths = new ImagesPaths();
    DefaultValues values = new DefaultValues();
    ScreensPaths screensPaths = new ScreensPaths();

    // screens to be loaded with their names
    private HashMap<String,Node> elements = new HashMap<String, Node>();
    private Node mainContent;

    public MainWindowController() {

        // setting screen parent for purposes of general login-main window sych
        setScreenParent(superController);
        phaseSynchronizer = PhaseSynchronizer.getInstance();

        // [ screen1 ], [ screen2 ], [ screen3 ], ...
        // loading all possible screens to this form
        loadScreens();
    }

    @FXML
    void initialize() {
        // first formatting buttons
        paintButtonsDefault();
        formatMenuButtonsExpanded();

        // saving main screen
        try {
            mainContent = buildPane.getChildren().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventHandler<ActionEvent> clickHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // identify the source and make apprioprate reaction
                if (event.getSource() == logOutButton) {
                    phaseSynchronizer.setNotLoggedPhase();
                    phaseSynchronizer.notifyObservers();

                    // reseting the main content
                    resetScreen();
                }
            }
        };
        logOutButton.addEventHandler(ActionEvent.ACTION, clickHandler);

        // add new track button is clicked
        addTrackButton.setOnAction( e -> {
            // switch the content to add new track form
            setScreen(screensPaths.AddNewTrackScreen);
        });

        // remove track button is clicked
        removeTrackButton.setOnAction( e -> {
            setScreen(screensPaths.TrackListScreen);
        });

    }

    @FXML
    void logOutEntered() {
        logOutButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void logOutExited() {
        logOutButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    @FXML
    void settingsEntered() {
        settingsButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void settingsExited() {
        settingsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    @FXML
    void statsEntered() {
        statsButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void statsExited() {
        statsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    @FXML
    void infoEntered() {
        infoButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void infoExited() {
        infoButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    @FXML
    void refreshEntered() {
        refreshButton.setStyle("-fx-background-color: rgb(216, 217, 198);");
    }

    @FXML
    void refreshExited() {
        refreshButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
    }

    private void paintButtonsDefault() {
        logOutButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        settingsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        statsButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        infoButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        refreshButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
        themeButton.setStyle("-fx-background-color: rgb(245, 245, 235);");
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

    private void resetScreen() {
        if (mainContent != null) {
            if (buildPane.getChildren() != null) {
                buildPane.getChildren().remove(0);
                buildPane.getChildren().add(mainContent);
            }
            else {
                buildPane.getChildren().add(mainContent);
            }
        }
    }


    private void formatMenuButtonsExpanded() {
        // formatting buttons in expanded position
        // accessing images
        Image imageLogOut = new Image(imagesPaths.LOGOUT_IMAGE_PATH);
        Image imageSettings = new Image(imagesPaths.SETTINGS_IMAGE_PATH);
        Image imageStats = new Image(imagesPaths.STATS_IMAGE_PATH);
        Image imageWeb = new Image(imagesPaths.WEB_IMAGE_PATH);
        Image imageRefresh = new Image(imagesPaths.REFRESH_IMAGE_PATH);
        // adding them to list of ImageViews
        ImageView logOutButtonContent = new ImageView(imageLogOut);
        ImageView settingsButtonContent = new ImageView(imageSettings);
        ImageView statsButtonContent = new ImageView(imageStats);
        ImageView infoButtonContent = new ImageView(imageWeb);
        ImageView refreshButtonContent = new ImageView(imageRefresh);

        logOutButtonContent.setFitWidth(40);
        logOutButtonContent.setFitHeight(40);

        settingsButtonContent.setFitHeight(40);
        settingsButtonContent.setFitWidth(40);

        statsButtonContent.setFitWidth(40);
        statsButtonContent.setFitHeight(40);

        infoButtonContent.setFitHeight(35);
        infoButtonContent.setFitWidth(35);

        refreshButtonContent.setFitWidth(40);
        refreshButtonContent.setFitHeight(40);

        logOutButton.setGraphic(logOutButtonContent);
        settingsButton.setGraphic(settingsButtonContent);
        statsButton.setGraphic(statsButtonContent);
        infoButton.setGraphic(infoButtonContent);
        refreshButton.setGraphic(refreshButtonContent);
    }

    // from IControllable
    @Override
    public void setScreenParent(ScreensContainer superController) {
        this.superController = superController;
    }

}
