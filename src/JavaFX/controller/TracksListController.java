package JavaFX.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import modelsFX.TableElementFX;
import modelsFX.TableImageFX;
import modelsFX.TrackFX;

import static javafx.collections.FXCollections.observableArrayList;

public class TracksListController {

    /*
    This is controller for all functionality in main lsit of tracks and playlists
     */

    ApplicationController windowsMediator;    // controller to communicate between all controllers of different windows

    // upper bar buttons
    // ( piosenki )
    @FXML
    ToggleButton showTracksButton;

    // ( plylisty )
    @FXML
    ToggleButton showPlaylistsButton;

    // ( usuń zaznaczone )
    @FXML
    Button removeMarkedButton;

    // ( resetuj zaznaczenie )
    @FXML
    Button resetButton;

    // ( kolorowanie )
    @FXML
    ToggleButton switchColorsButton;

    // main table view - for all data
    @FXML
    TableView<TableElementFX> mainTable;

    // columns of the main table
    // | miniaturka | tytuł | autor | ocena | data dodania | źródło | czas trwania | link |
    @FXML
    TableColumn<TableElementFX, TableImageFX> thumbnailColumn;

    @FXML
    TableColumn<TableElementFX, String> titleColumn;

    @FXML
    TableColumn<TableElementFX, String> authorColumn;

    @FXML
    TableColumn<TableElementFX, Integer> rankColumn;

    @FXML
    TableColumn<TableElementFX, String> dateColumn;

    @FXML
    TableColumn<TableElementFX, String> sourceColumn;

    @FXML
    TableColumn<TableElementFX, String> timeColumn;

    @FXML
    TableColumn<TableElementFX, String> linkColumn;

    @FXML
    Button exitButton;

    // properties
    // this many records can be held in memory at once
    private static final int tableCapacity = 200;
    private static boolean showTracksOnly = false;
    private static boolean showPlaylistsOnly = false;
    private static boolean colorsSwitchedOn = false;

    // list to have all tracks
    ObservableList<TableElementFX> elements = observableArrayList();

    public void initialize() {
        // show only tracks
        showTracksButton.setOnAction( e -> {
            showTracksOnly = showTracksOnly == true ? false : true;
        });

        // show only playlists
        showPlaylistsButton.setOnAction( e -> {
            showPlaylistsOnly = showPlaylistsOnly == true ? false : true;
        });

        // remove selected
        removeMarkedButton.setOnAction( e -> {

        });

        // reset the selections, opened resources and showing
        resetButton.setOnAction( e -> {

        });

        // start colofing the records
        switchColorsButton.setOnAction( e -> {
            colorsSwitchedOn = colorsSwitchedOn == true ? false : true;
        });

        exitButton.setOnAction( e -> {
            windowsMediator.mainWindowSetToDefault();
        });
    }

    public void importData() {
        // is the controller of how many tracks will be taken in which order from db
        // probably add this to a class
    }

    private void displayImportedData() {
        // displays all data imported from db
    }

    public TracksListController() {
        windowsMediator = ApplicationController.getInstance();
        windowsMediator.registerTracksListController(this);
    }

}
