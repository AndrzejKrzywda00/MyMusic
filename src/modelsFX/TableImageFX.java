package modelsFX;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TableImageFX {

    /*
    This is a custom class that encapsulates the ImageView to be used in displaying
    in a TableView
     */

    private ImageView image;

    public TableImageFX() {

    }

    // loading data from file
    public TableImageFX loadImage(String URL) {
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
