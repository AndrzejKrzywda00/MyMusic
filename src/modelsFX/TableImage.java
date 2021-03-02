package modelsFX;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TableImage {

    /*
    This is a custom class that encapsulates the ImageView to be used in displaying
    in a TableView
     */

    private ImageView image;

    public TableImage() {

    }

    // loading data from file
    public TableImage loadImage(String URL) {
        Image content = new Image(URL);
        image = new ImageView(content);
        return this;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

}
