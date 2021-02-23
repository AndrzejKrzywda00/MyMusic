package newTrackWindowConstants;

import enums.Rating;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class DefaultValues {

    // this class holds all default values for a newly created track
    // they are to see in ClientApp.Track.java

    public static final int DEFAULT_LENGTH_IN_SECONDS = -1;  // will be possibly changed to something more default
    public static final String DEFAULT_FORMAT = "no format added";
    public static final Rating DEFAULT_RATING = Rating.NotInitalized;
    public static final String DEFAULT_DESCRIPTION = "a music file";
    public static final String DEFAULT_THUMBNAIL_LINK = "generic thumbnail";
    public static final String DEFAULT_TRACK_LINK = "no link added";

    // this probably won't work - i was right - it crashes
    //public static final Image DEFAULT_IMAGE = new Image("an imput stream to file");

    // defaults for animation of buttons
    public static final int SINGLE_ANIMATION = 1;

    // animation time in MILISECONDS
    public static final double TIME_OF_PLUS_BUTTON_ANIMATION = 200;

    // how many images will be in side menu
    public static final int HOW_MANY_IMAGES = 6;

    // color in rgb format
    public static final Color NON_ACTIVE_GREY = Color.rgb(245, 245, 235);
    public static final Color ACTIVE_GREY = Color.rgb(206, 207, 192);

}
