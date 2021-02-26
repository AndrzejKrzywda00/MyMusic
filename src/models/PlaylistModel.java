package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class PlaylistModel {

    /*
    This class is a representation of Playlist class but
    has Properties as fields
     */

    private TableImage thumbnail;
    private StringProperty name;
    private StringProperty author;      // will have complicated generation

    private IntegerProperty rating;
    private StringProperty date;
    private StringProperty source;
    private StringProperty length;
    private StringProperty link;

    public PlaylistModel() {

    }

    public TableImage getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(TableImage thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return name.get();
    }

    public StringProperty titleProperty() {
        return name;
    }

    public void setTitle(String title) {
        this.name.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public int getRating() {
        return rating.get();
    }

    public IntegerProperty ratingProperty() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating.set(rating);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getSource() {
        return source.get();
    }

    public StringProperty sourceProperty() {
        return source;
    }

    public void setSource(String source) {
        this.source.set(source);
    }

    public String getLength() {
        return length.get();
    }

    public StringProperty lengthProperty() {
        return length;
    }

    public void setLength(String length) {
        this.length.set(length);
    }

    public String getLink() {
        return link.get();
    }

    public StringProperty linkProperty() {
        return link;
    }

    public void setLink(String link) {
        this.link.set(link);
    }



}
