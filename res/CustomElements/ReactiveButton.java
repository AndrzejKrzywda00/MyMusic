package CustomElements;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class ReactiveButton extends Button {

    // this is button which provides additional options for me to utilize

    // 1. It can be animated
    // 2. it can have an image added
    // 3. it can have text added
    // 4. it is in custom shape
    // 5. it has reactive nautre - changes colors when mouse is over

    Color nonActiveBackground;
    Color activeBackground;

    public ReactiveButton() {
        // warning - cursor IS hand just by default
        this.setCursor(Cursor.HAND);
    }

    public void passAllData(Color activeBackground, Color nonActiveBackground) {
        this.activeBackground = activeBackground;
        this.nonActiveBackground = nonActiveBackground;
    }

    public Boolean isImageAdded() {
        return this.getGraphic() != null;
    }

}
