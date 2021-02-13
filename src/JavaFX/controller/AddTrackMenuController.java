package JavaFX.controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import newTrackWindowConstants.ImagesConstants;
import newTrackWindowConstants.ImagesPaths;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class AddTrackMenuController {

    // This clas is the controller of the menu that adds a new track

    // WARNING - you can have cosillion here of two controllers when adding this to mainWindow.fxml

    // important content classes instances
    ImagesPaths imagesContent = new ImagesPaths();

    ImagesConstants imagesConstants = new ImagesConstants();

    // accessing actual data
    //Image plusRound = new Image(imagesContent.PLUS_IMAGE_PATH);
    //ImageView plusButtonContent = new ImageView(plusRound);

    // initializing empty ArratyList for all instances of ImageViews needed for buttons
    ArrayList<ImageView> plusImages = new ArrayList<ImageView>(imagesConstants.HOW_MANY_IMAGES);

    /*
    These are plus Images that have to open fields for optional parameters
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

    // methods

    @FXML
    public void plusButtonClicked(ActionEvent event) {

        // universal method of handling clicking on the one of five plusButtons

        // 1. button
        if (event.getSource() == plusTimeButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
        }

        // 2. button
        if (event.getSource() == plusFormatButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
        }

        // 3. button
        if (event.getSource() == plusDescriptionButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
        }

        // 4. button
        if (event.getSource() == plusRatingButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
        }

        // 5. button
        if (event.getSource() == plusThumbnailButton) {
            // modify accessiblity of fields
            // animate the fields
            // animate the button
        }
    }

    // constructor
    public AddTrackMenuController() {

    }

    // initalization
    public void initialize() {
        // below should be enough to have active fields
        // for labels just styling
        // for text fields probably styling as well
        // but still there is rectangle and so on
        // timeLasting.setDisable(true);
        // timeLasting.setStyle("css styling");

        // turning on graphical configuration
        // padding, displaying images, setting shape for buttons etc...
        setPlusButtonsConfiguration();
        //plusTimeButton.addEventHandler();




    }

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

    // TODO -- add all functioanlity connected to animation, not-active state of fields, responsiveness, time setter



}
