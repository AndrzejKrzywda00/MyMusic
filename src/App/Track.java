package App;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import App.Utils.URLParser;
import Interfaces.ITextSerializeable;
import enums.*;
import javafx.scene.layout.Pane;
import newTrackWindowConstants.DefaultValues;

import javax.print.attribute.standard.MediaSize;

public class Track implements ITextSerializeable {

    // Holds all vital information of a track in MyMusic Application.

    // mandatory -- user must add some data
    private String title;           // title of the track
    private String author;          // Author/authors of the track
    private String URL;             // is the link to actual track somewhere

    // optional (for user) -- defalut values can be used
    private int length;             // length of track - finally will be displayed in this format hours:minutes:seconds
    private String format;          // Format of music file for example ".mp3" or ".wav"
    private Rating rating;          // Rating added by user of the app
    private String description;     // description of the track added by user
    private String thumbnail;       // local link to the the thumbnail

    // added automatically -- no interaction with user
    private ID uniqueID;            // unique ID added when a track is archived or manually added
    private String addedDate;       // automaticaly added date of track archivisation day (YMD)
    private Origin origin;          // auto property added by program to know type of archivisation
    private Source source;          // source tells where to look for the actual track

    public Track() {
        // default values
        DefaultValues defaultValues = new DefaultValues();

        length = defaultValues.DEFAULT_LENGTH_IN_SECONDS;
        format = defaultValues.DEFAULT_FORMAT;
        rating = defaultValues.DEFAULT_RATING;
        description = defaultValues.DEFAULT_DESCRIPTION;
        thumbnail = defaultValues.DEFAULT_THUMBNAIL_LINK;
        URL = defaultValues.DEFAULT_TRACK_LINK;

        // empty constructor for Builder
        uniqueID = new ID();

        // date managing
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        addedDate = formatter.format(today);

        // origin
        origin = Origin.ManualAddition; // for now it's hard coded
    }

    // this should be changed -- it not elegant
    public void generateSource() {
        URLParser parser = new URLParser();
        Type output = parser.parse(URL);
        if (output != null) {
            Source newSource = new Source(URL, output, true);
            source = newSource;
            return;
        }
    }

    public String serialize() {

        StringBuilder output = new StringBuilder();

        output.append(title);
        output.append(";");
        output.append(source.serialize());
        output.append(author);
        output.append(";");

        output.append(length);
        output.append(";");
        output.append(format);
        output.append(";");
        output.append(rating.serialize());
        output.append(description);
        output.append(";");


        output.append(thumbnail);
        output.append(";");

        output.append(uniqueID.serialize());
        output.append(addedDate);
        output.append(";");
        output.append(origin.serialize());

        return output.toString();
    }

    public boolean isFinished() {
        return false;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setLength(int lengthInSeconds) {
        this.length = lengthInSeconds;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getURL() {
        return URL;
    }

    public int getLength() {
        return length;
    }

    public String getFormat() {
        return format;
    }

    public Rating getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public Source getSource() {
        return source;
    }

    public String getLengthInString() {
        String output;
        int hours = (length / 3600);
        int minutes = (length - 3600 * hours) / 60;
        int seconds = length - hours * 3600 - minutes * 60;
        output = Integer.toString(hours) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds);
        return output;
    }

}

