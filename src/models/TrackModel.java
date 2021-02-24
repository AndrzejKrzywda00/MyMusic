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
    private StringProperty author;

    private IntegerProperty rating;     // first just number of stars but later an image
    private StringProperty date;
    private StringProperty source;
    private StringProperty length;
    private StringProperty link;    // clickable

    public TrackModel() {

    }

}
