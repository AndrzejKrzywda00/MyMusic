package ClientApp;

import java.util.Date;

import Interfaces.ITextSerializeable;
import enums.*;
import javafx.scene.image.Image;

public class Track implements ITextSerializeable {

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
    private Image thumbnail;        // just the thumbnail

    // added automatically -- no interaction with user
    private ID uniqueID;            // unique ID added when a track is archived or manually added
    private Date addedDate;         // automaticaly added date of track archivisation day (YMD)
    private Origin origin;          // auto property added by program to know type of archivisation

    // other methods
    public Image getThumbnail() {
        return this.thumbnail;
    }

    public String serialize() {

        StringBuilder output = new StringBuilder();

        output.append(title);
        output.append(";");
        output.append(source);
        output.append(";");
        output.append(author);
        output.append(";");

        output.append(lengthInSeconds);
        output.append(";");
        output.append(format);
        output.append(";");
        output.append(rating.serialize());
        output.append(description);
        output.append(";");

        //questionable
        //output.append(thumbnail);
        //output.append(";");

        output.append(uniqueID.serialize());
        output.append(addedDate);
        output.append(";");
        output.append(origin.serialize());

        return output.toString();
    }

}

