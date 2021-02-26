package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class TrackModel {

    /*
    This class is a representation of Track class but instead of simple types this class has properties
    Which are going to be used in managing TableView content
    So this is strictly for displaying purposes
     */

    private TableImage thumbnail;
    private StringProperty title;
    private StringProperty authors;

    private IntegerProperty rating;     // first just number of stars but later an image
    private StringProperty date;
    private StringProperty source;
    private StringProperty length;
    private StringProperty link;    // clickable

    public TrackModel() {

    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthors() {
        return authors.get();
    }

    public StringProperty authorsProperty() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors.set(authors);
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

    public void setThumbnail(TableImage thumbnail) {
        this.thumbnail = thumbnail;
    }


}
