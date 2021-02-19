package newTrackWindowConstants;

import java.util.HashMap;

public class ScreensPaths {

    public static final HashMap<String,String> screens = new HashMap<String,String>();
    public static final String AddNewTrackScreen = "addNewTrackMenu";
    public static final String RemoveTrackScreen = "removeTrackMenu";
    public static final String PlaylistScreen = "playlistMenu";
    public static final String TrackListScreen = "tracksListMenu";

    public ScreensPaths() {
        screens.put(AddNewTrackScreen, "/FXMLfiles/addTrackMenu.fxml");
        screens.put(RemoveTrackScreen, "/FXMLfiles/removeTrackMenu.fxml");
        screens.put(PlaylistScreen, "/FXMLfiles/playlistsMenu.fxml");
        screens.put(TrackListScreen, "/FXMLfiles/tracksListMenu.fxml");
    }

}
