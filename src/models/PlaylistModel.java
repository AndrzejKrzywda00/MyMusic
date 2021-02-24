package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class PlaylistModel {

    /*
    This class is a representation of Playlist class but
    has Properties as fields
     */

    private TableImage thumbnail;
    private StringProperty title;
    private StringProperty author;      // will have complicated generation

    private IntegerProperty rating;
    private StringProperty date;
    private StringProperty source;
    private StringProperty length;
    private StringProperty link;

    public PlaylistModel() {
        
    }

}
