package ClientApp;

import java.util.Date;
import enums.*;
import javafx.scene.image.Image;

public class Track {

    // Holds all vital information of a track in MyMusic Application.

    // mandatory -- user must add some data
    private String title;           // title of the track
    private Source source;          // source tells where to look for the actual track
    private String author;          // Author/authors of the track

    // optional (for user) -- defalut values can be used
    private int lengthInSeconds;    // length of track - finally will be displayed in this format hours:minutes:seconds
    private String format;          // Format of music file for example ".mp3" or ".wav"
    private Rating rating;          // Rating added by user of the app
    private String description;     // description of the track added by user
    private Image img;              // just the thumbnail

    // added automatically -- no interaction with user
    private ID uniqueID;            // unique ID added when a track is archived or manually added
    private Date addedDate;         // automaticaly added date of track archivisation day
    private Origin origin;          // auto property added by program to know type of archivisation

    // other methods
    public Image getImg() {
        return this.img;
    }

}

