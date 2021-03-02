package JavaFX.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import modelsFX.TrackModel;

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
    TableView mainTable;

    // columns of the main table
    // | miniaturka | tytuł | autor | ocena | data dodania | źródło | czas trwania | link |
    @FXML
    TableColumn thumbnailColumn;

    @FXML
    TableColumn titleColumn;

    @FXML
    TableColumn authorColumn;

    @FXML
    TableColumn rankColumn;

    @FXML
    TableColumn dateColumn;

    @FXML
    TableColumn sourceColumn;

    @FXML
    TableColumn timeColumn;

    @FXML
    TableColumn linkColumn;

    @FXML
    Button exitButton;

    // properties
    // this many records can be held in memory at once
    private static final int tableCapacity = 200;
    private static boolean showTracksOnly = false;
    private static boolean showPlaylistsOnly = false;
    private static boolean colorsSwitchedOn = false;

    // a group for columns to format them
    private Group topButtons;

    // list to have all tracks
    ObservableList<TrackModel> tracks = observableArrayList();

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

    public void importTracks() {
        // calls the right elements to import tracks from database
    }

    public void addTrack(TrackModel track) {

    }

    public TracksListController() {
        windowsMediator = ApplicationController.getInstance();
        windowsMediator.registerTracksListController(this);
    }

}
