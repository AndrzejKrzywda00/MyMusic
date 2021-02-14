package JavaFX.controller;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import newTrackWindowConstants.DefaultValues;
import newTrackWindowConstants.ImagesConstants;
import newTrackWindowConstants.ImagesPaths;

import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AddTrackMenuController {

    // This clas is the controller of the menu that adds a new track
    // WARNING - you can have cosillion here of two controllers when adding this to mainWindow.fxml

    // important content classes instances
    ImagesPaths imagesContent = new ImagesPaths();
    ImagesConstants imagesConstants = new ImagesConstants();
    DefaultValues defaultValues = new DefaultValues();

    // initializing empty ArratyList for all instances of ImageViews needed for buttons
    ArrayList<ImageView> plusImages = new ArrayList<ImageView>(imagesConstants.HOW_MANY_IMAGES);

    // this list cotains values of all plus buttons to remember in which state the animation is
    // for false "(+)" needs to go 90 degrees to the left
    // for true "(+)" needs to go 90 degrees to the right
    ArrayList<Boolean> rotationCache = new ArrayList<Boolean>(imagesConstants.HOW_MANY_IMAGES);

    // handling pasting usting Clipboard
    private final Clipboard clipboard = Clipboard.getSystemClipboard();
    private final ClipboardContent clipboardContent = new ClipboardContent();

    /*
    These are buttons that have to open fields for optional parameters
     */
    @FXML
    Button plusTimeButton;

    @FXML
    Button plusFormatButton;

    @FXML
    Button plusDescriptionButton;

    @FXML
    Button plusRatingButton;

    @FXML
    Button plusThumbnailButton;

    //             <--
    // wklej URL ze schowka - button
    @FXML
    Button pasteURLButton;

    // TextFields

    @FXML
    TextField URLTextField;

    // methods

    @FXML
    public void plusButtonClicked(ActionEvent event) {

        // TODO -- think how to make it look better
        // universal method of handling clicking on the one of five plusButtons

        RotateTransition rotate90degreesClockwise = new RotateTransition();
        rotate90degreesClockwise.setDuration(Duration.millis(defaultValues.TIME_OF_PLUS_BUTTON_ANIMATION));
        rotate90degreesClockwise.setAxis(Rotate.Z_AXIS);
        rotate90degreesClockwise.setCycleCount(defaultValues.SINGLE_ANIMATION);
        rotate90degreesClockwise.setByAngle(90/* degrees */ );    // difference in angle

        RotateTransition rotate90degreesCounterClockwise = new RotateTransition();
        rotate90degreesCounterClockwise.setDuration(Duration.millis(defaultValues.TIME_OF_PLUS_BUTTON_ANIMATION));
        rotate90degreesCounterClockwise.setAxis(Rotate.Z_AXIS);
        rotate90degreesCounterClockwise.setCycleCount(defaultValues.SINGLE_ANIMATION);
        rotate90degreesCounterClockwise.setByAngle(-90/* degrees */);    // difference in angle

        // 1. button
        if (event.getSource() == plusTimeButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
            if ( rotationCache.get(0) == false ) {
                rotate90degreesClockwise.setNode(plusTimeButton);   // normal rotation
                rotationCache.set(0,true);                          // now cache will remeber the state
                rotate90degreesClockwise.play();
            }
            else {
                // reversed rotaion
                rotate90degreesCounterClockwise.setNode(plusTimeButton);
                rotationCache.set(0,false);
                rotate90degreesCounterClockwise.play();
            }

        }

        // 2. button
        if (event.getSource() == plusFormatButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
            if ( rotationCache.get(1) == false ) {
                rotate90degreesClockwise.setNode(plusFormatButton);     // normal rotation
                rotationCache.set(1,true);                              // now cache will remeber the state
                rotate90degreesClockwise.play();
            }
            else {
                rotate90degreesCounterClockwise.setNode(plusFormatButton);    // reversed rotation
                rotationCache.set(1,false);
                rotate90degreesCounterClockwise.play();
            }
        }

        // 3. button
        if (event.getSource() == plusDescriptionButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
            if ( rotationCache.get(2) == false ) {
                rotate90degreesClockwise.setNode(plusDescriptionButton);        // normal rotation
                rotationCache.set(2,true);                                      // now cache will remeber the state
                rotate90degreesClockwise.play();
            }
            else {
                rotate90degreesCounterClockwise.setNode(plusDescriptionButton);    // reversed rotation
                rotationCache.set(2,false);
                rotate90degreesCounterClockwise.play();
            }
        }

        // 4. button
        if (event.getSource() == plusRatingButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
            if ( rotationCache.get(3) == false ) {
                rotate90degreesClockwise.setNode(plusRatingButton);       // normal rotation
                rotationCache.set(3,true);                                     // now cache will remeber the state
                rotate90degreesClockwise.play();
            }
            else {
                rotate90degreesCounterClockwise.setNode(plusRatingButton);    // reversed rotation
                rotationCache.set(3,false);
                rotate90degreesCounterClockwise.play();
            }
        }

        // 5. button
        if (event.getSource() == plusThumbnailButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
            if ( rotationCache.get(4) == false ) {
                rotate90degreesClockwise.setNode(plusThumbnailButton);     // normal rotation
                rotationCache.set(4,true);                                   // now cache will remeber the state
                rotate90degreesClockwise.play();
            }
            else {
                rotate90degreesCounterClockwise.setNode(plusThumbnailButton);    // reversed rotation
                rotationCache.set(4,false);
                rotate90degreesCounterClockwise.play();
            }
        }
    }

    // constructor
    public AddTrackMenuController() {
        populateRotationCache();
    }

    // initalization
    public void initialize() {
        // turning on graphical configuration
        // padding, displaying images, setting shape for buttons etc...
        setPlusButtonsConfiguration();
        setPasteURLButtonConfiguration();

        pasteURLButton.setOnAction( e -> {
            pasteURLToTextField();
            System.out.println(clipboardContent.getUrl());
        });
    }

    /***
     * This function performs whole configuration of buttons of adding optional parameters to a new track
     * It adds images to buttons and shapes them properly
     */
    void setPlusButtonsConfiguration() {

        // performing all configuration of all five buttons
        // they are aligned like this:

        // --------
        // 1. (+) czas trwania
        // 2. (+) format
        // 3. (+) opis
        // 4. (+) ocena
        // 5. (+) miniaturka
        // --------

        // zero step is to create local versions of images for each button
        populateImagesList();

        // first we need to properly format the images
        formatPlusButtonsImages();

        // second adding images to them
        // 1. button
        plusTimeButton.setShape(new Circle(imagesConstants.PLUS_BUTTON_RADIUS));
        plusTimeButton.setGraphic(plusImages.get(0));
        plusTimeButton.setPadding(Insets.EMPTY);

        // 2. button
        plusFormatButton.setShape(new Circle(imagesConstants.PLUS_BUTTON_RADIUS));
        plusFormatButton.setGraphic(plusImages.get(1));
        plusFormatButton.setPadding(Insets.EMPTY);

        // 3. button
        plusDescriptionButton.setShape(new Circle(imagesConstants.PLUS_BUTTON_RADIUS));
        plusDescriptionButton.setGraphic(plusImages.get(2));
        plusDescriptionButton.setPadding(Insets.EMPTY);

        // 4. button
        plusRatingButton.setShape(new Circle(imagesConstants.PLUS_BUTTON_RADIUS));
        plusRatingButton.setGraphic(plusImages.get(3));
        plusRatingButton.setPadding(Insets.EMPTY);

        // 5. button
        plusThumbnailButton.setShape(new Circle(imagesConstants.PLUS_BUTTON_RADIUS));
        plusThumbnailButton.setGraphic(plusImages.get(4));
        plusThumbnailButton.setPadding(Insets.EMPTY);

    }

    /***
     * This function populates list of ImageView objects with concrete .png file
     * This file is set to be plus on dark background
     */
    void populateImagesList() {

        for ( int i=0; i<imagesConstants.HOW_MANY_IMAGES; i++ ) {
            Image plus = new Image(imagesContent.PLUS_IMAGE_PATH);
            ImageView plusContent = new ImageView(plus);
            plusImages.add(plusContent);
        }

        // alternative way but it seem to not work
        /*
        for ( ImageView image : plusImages ) {
            Image plus = new Image(imagesContent.PLUS_IMAGE_PATH);
            image = new ImageView(plus);
        }
         */

    }

    /***
     * This function sets the dimensions of image to fit in the form
     * For now it uses constant values for 45 px X 45 px
     */
    void formatPlusButtonsImages() {
        // formating images which will be added to buttons ( width = height )
        for ( ImageView plusButtonContent : plusImages) {
            plusButtonContent.setFitHeight(imagesConstants.PLUS_IMAGE_HEIGHT);
            plusButtonContent.setFitWidth(imagesConstants.PLUS_IMAGE_WIDTH);
        }
    }

    /***
     * This function fills the ArrayList rotationCache with default - false values
     */
    void populateRotationCache() {
        for ( int i=0; i<imagesConstants.HOW_MANY_IMAGES; i++ ) {
            rotationCache.add(false);   // at the begging all nodes are in neutral state
        }
    }

    // now setting up pasting button configuration which is right to the URL section

    /***
     * This function sets all vital configuration for pasting URL button
     * It consists of an arrow image and text below
     */
    void setPasteURLButtonConfiguration() {
        Image image = new Image(imagesContent.PASTE_ARROW_PATH);
        ImageView arrowImage = new ImageView(image);
        arrowImage.setFitHeight(40);
        arrowImage.setFitWidth(40);
        pasteURLButton.setGraphic(arrowImage);
        pasteURLButton.setPadding(Insets.EMPTY);
    }


    void pasteURLToTextField() {
        URLTextField.setText(clipboardContent.getString());
    }


    // TODO -- not-active state of fields, responsiveness, time setter



}
