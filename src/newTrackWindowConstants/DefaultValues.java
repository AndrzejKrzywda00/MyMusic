package newTrackWindowConstants;

import enums.Rating;
import javafx.scene.image.Image;

public class DefaultValues {

    // this class holds all default values for a newly created track
    // they are to see in ClientApp.Track.java

    public static final int DEFAULT_LENGTH_IN_SECONDS = -1;  // will be possibly changed to something more default
    public static final String DEFAULT_FORMAT = "no format added";
    public static final Rating DEFAULT_RATING = Rating.NotInitalized;
    public static final String DEFAULT_DESCRIPTION = "a music file";

    // this probably won't work - i was right - it crashes
    //public static final Image DEFAULT_IMAGE = new Image("an imput stream to file");

    // defaults for animation of buttons
    public static final int SINGLE_ANIMATION = 1;

    // animation time in MILISECONDS
    public static final double TIME_OF_PLUS_BUTTON_ANIMATION = 200;

}