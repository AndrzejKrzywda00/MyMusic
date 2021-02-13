package JavaFX.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import newTrackWindowConstants.ImagesPaths;

public class AddTrackMenuController {

    // This clas is the controller of the menu that adds a new track

    // WARNING - you can have cosillion here of two controllers when adding this to mainWindow.fxml

    // important content classes instances
    ImagesPaths imagesContent = new ImagesPaths();

    /*
    These are plus Images that have to open fields for optional parameters
     */
    @FXML
    ImageView plusImageTime;

    @FXML
    ImageView plusImageFormat;

    @FXML
    ImageView plusImageDescription;

    @FXML
    ImageView plusImageRank;

    @FXML
    ImageView plusImageMin;

    @FXML
    Button plusTimeButton;

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

        Image plusRound = new Image(imagesContent.PLUS_IMAGE_PATH);
        ImageView plusTimeButtonContent = new ImageView(plusRound);
        plusTimeButtonContent.setFitHeight(45);
        plusTimeButtonContent.setFitWidth(45);
        // not exatly necessary
        plusTimeButtonContent.setPreserveRatio(true);
        plusTimeButton.setGraphic(plusTimeButtonContent);

    }

    // TODO -- add all functioanlity connected to animation, not-active state of fields, responsiveness, time setter



}
