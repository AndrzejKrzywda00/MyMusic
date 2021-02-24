package models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TableImage {

    /*
    This is a custom class that encapsulates the ImageView to be used in displaying
    in a TableView
     */

    private ImageView image;

    public TableImage(ImageView image) {
        this.image = image;
    }

    // loading data from file
    public void loadImage(String URL) {
        Image content = new Image(URL);
        image = new ImageView(content);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

}
