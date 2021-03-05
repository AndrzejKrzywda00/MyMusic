package newTrackWindowConstants;

import java.util.HashMap;

public class ScreensPaths{

    public static final HashMap<String,String> screens = new HashMap<String,String>();
    public static final String AddNewTrackScreen = "addNewTrackMenu";
    public static final String PlaylistScreen = "playlistMenu";
    public static final String TrackListScreen = "tracksListMenu";
    public static final String SideMenuExpanded = "sideMenuBig";
    public static final String SideMenuHidden = "sideMenuHidden";
    public static final String ArchivizePlaylistScreen = "archivizationScreen";

    public ScreensPaths() {
        screens.put(AddNewTrackScreen, "/FXMLfiles/addTrackMenu.fxml");
        screens.put(PlaylistScreen, "/FXMLfiles/playlistsMenu.fxml");
        screens.put(TrackListScreen, "/FXMLfiles/tracksListMenu.fxml");
        screens.put(SideMenuExpanded, "/sideMenuExpanded.fxml");
        screens.put(SideMenuHidden, "/FXMLfiles/sideMenuHidden.fxml");
        screens.put(ArchivizePlaylistScreen, "/FXMLfiles/archivizeFromNet.fxml");
    }

}
