package newTrackWindowConstants;

import java.util.HashMap;

public class ScreensPaths {

    public static final HashMap<String,String> screens = new HashMap<String,String>();
    public static final String AddNewTrackScreen = "addNewTrackMenu";

    public ScreensPaths() {
        screens.put(AddNewTrackScreen, "/FXMLfiles/addTrackMenuSource.fxml");
    }

}
