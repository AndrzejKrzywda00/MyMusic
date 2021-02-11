package JavaFX.controller;

//import com.sun.javafx.geom.Rectangle;
import ClientApp.LoginContent;
import CustomControls.TextFieldLimited;
import LoginWindowConstants.LoginElementsColors;
import LoginWindowConstants.LoginStrings;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginWindowController {

    // TODO -- fill string magic values with proper resource bundles in two languages
    // partially done
    private static final int TEXT_FIELDS_CAPACITY = 20;

    // to be removed
    private Boolean authorized = true;

    // contenet classes
    // TODO -- possiblly add decorators to them
    private LoginStrings stringContens = new LoginStrings();
    private LoginElementsColors colorProbe = new LoginElementsColors();

    // important functional classes
    LoginContent loginContent = new LoginContent();

    // important local variables
    Boolean wantsToBeRemembered = false; // takes the data from button 'rememberMeButton'

    /* Here controlling all information flow and configuration of logging window */
    @FXML
    Button loginButton;

    @FXML
    Button registerButton;

    @FXML
    Rectangle loginRectangle;

    @FXML
    Rectangle registrationRectangle;

    @FXML
    PasswordField passwordTextField;

    @FXML
    TextFieldLimited loginTextField;

    @FXML
    Pane loginFailedPane;

    @FXML
    Rectangle loginTextRectangle;

    @FXML
    Rectangle passwordTextRectangle;

    @FXML
    ImageView tickRememberMe;   // image of the tick

    @FXML
    Button rememberMeButton;    // button covering 'remember me' text and box

    @FXML
    void initialize() {

        // constructing the limited custom text field
        loginTextField = new TextFieldLimited(/*TEXT_FIELDS_CAPACITY*/3);

        // constructing the limited custom password field


        rememberMeButton.setOnAction( e -> {

            // checking/unchecking the tick button -- this (int) override is always safe -- this is for other engineers
            int newOpacity = (tickRememberMe.getOpacity() == colorProbe.INVISIBLE) ? (int)colorProbe.FULLY_VISIBLE : (int)colorProbe.INVISIBLE;
            tickRememberMe.setOpacity(newOpacity);

            // whenever the button is clicked, the value will be inverted
            wantsToBeRemembered = (wantsToBeRemembered == false) ? true : false;
        });
    }

    @FXML
    void loginButtonClicked() {

        if (authorized) {
            // always authorized for now
        }
        else {
            // type informationa ab. wrong pasword or worng email using new fxml file
            loginFailedPane.setOpacity(colorProbe.FULLY_VISIBLE);
            loginTextRectangle.setStroke(colorProbe.WRONG_DATA_RED);
            loginTextRectangle.setStrokeWidth(colorProbe.DEFAULT_WIDTH);
            passwordTextRectangle.setStroke(colorProbe.WRONG_DATA_RED);
            passwordTextRectangle.setStrokeWidth(colorProbe.DEFAULT_WIDTH);
        }

        // pack data to class and to be later sent to server
        loginContent.getAllData(loginTextField.getText(), passwordTextField.getText(), wantsToBeRemembered);

        // clearing the text fields (all cases)
        passwordTextField.setText(stringContens.EMPTY_STRING);
        loginTextField.setText(stringContens.EMPTY_STRING);

        System.out.println(loginContent.serialize());
    }

    @FXML
    void loginButtonEntered() {
        loginRectangle.setFill((Color)colorProbe.LOGIN_ACTIVE);
    }

    @FXML
    void loginButtonExited() {
        loginRectangle.setFill((Color)colorProbe.LOGIN_INACTIVE);
    }

    @FXML
    void registerButtonEntered() {
        registrationRectangle.setFill((Color)colorProbe.REGISTER_ACTIVE);
    }

    @FXML
    void registerButtonExited() {
        registrationRectangle.setFill((Color)colorProbe.REGISTER_INACTIVE);
    }

    @FXML
    void registerButtonClicked() {
        /* Direct user to registration form */
    }

    // TODO -- make an option to show password & make an emeregncy window to show up when login failed
    // also add links and labels to registration and main logo

    public LoginWindowController() {

    }

}
