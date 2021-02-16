package JavaFX.controller;

//import com.sun.javafx.geom.Rectangle;
import ClientApp.DataContent.LoginContent;
import ClientApp.PhaseSynchronizer;
import Interfaces.IControllable;
import LoginWindowConstants.LoginElementsColors;
import LoginWindowConstants.LoginStrings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginWindowController implements IControllable {

    // TODO -- fill string magic values with proper resource bundles in two languages
    // partially done
    private static final int TEXT_FIELDS_CAPACITY = 25;

    // to be removed
    private Boolean authorized = true;

    // contenet classes
    // TODO -- possiblly add decorators to them
    private LoginStrings stringContens = new LoginStrings();
    private LoginElementsColors colorProbe = new LoginElementsColors();

    // important data classes
    LoginContent loginContent = new LoginContent();

    // important local variables
    Boolean wantsToBeRemembered = false; // takes the data from button 'rememberMeButton'

    // singleton Synchronizer for windows
    PhaseSynchronizer synchronizer = PhaseSynchronizer.getInstance();

    /* Here controlling all information flow and configuration of logging window */

    // ( ZALOGUJ ) - button
    @FXML
    Button loginButton;

    // ( ZAREJESTRUJ SIĘ ) - button
    @FXML
    Button registerButton;

    // ( ZALOGUJ ) - green rectangle
    @FXML
    Rectangle loginRectangle;

    // ( ZAREJESTRUJ SIĘ ) - blue rectangle
    @FXML
    Rectangle registrationRectangle;

    // hasło : ( *********** )
    @FXML
    PasswordField passwordTextField;

    // login : ( "UserName" )
    @FXML
    TextField loginTextField;

    // [X] - image
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
    ImageView logoImage;        // main big image

    @FXML
    void initialize() {

        // TODO - wrap this behaviour in one class:
        // login field will not take more than fixed number of characters
        loginTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.length() > TEXT_FIELDS_CAPACITY) {
                    loginTextField.setText(oldValue);
                }
            }
        });

        // password field will not take more than fixed number of characters
        passwordTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.length() > TEXT_FIELDS_CAPACITY) {
                    loginTextField.setText(oldValue);
                }
            }
        });

        // chceking if tick has been changed
        rememberMeButton.setOnAction( e -> {

            // checking/unchecking the tick button -- this (int) override is always safe -- this is for other engineers
            int newOpacity = (tickRememberMe.getOpacity() == colorProbe.INVISIBLE) ? (int)colorProbe.FULLY_VISIBLE : (int)colorProbe.INVISIBLE;
            tickRememberMe.setOpacity(newOpacity);

            // whenever the button is clicked, the value will be inverted
            wantsToBeRemembered = (wantsToBeRemembered == false) ? true : false;
        });

        // Tooltips

        // This tooltip informs you about moving to main page of the application
        Tooltip mainLogoTooltip = new Tooltip("Przejdź do głównej strony aplikacji MyMusic");
        Tooltip.install(logoImage, mainLogoTooltip);    // installing tooltip on main logo in application

    }

    @FXML
    void loginButtonClicked() {

        if (authorized) {
            // always authorized for now
            // update state of application through PhaseSynchronizer
            synchronizer.setLoggedPhase();  // we are logged now
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

        // clearing the text fields (all cases) and removing visibility of tick "remember me"
        passwordTextField.setText(stringContens.EMPTY_STRING);
        loginTextField.setText(stringContens.EMPTY_STRING);
        tickRememberMe.setOpacity(colorProbe.INVISIBLE);
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

    // TODO -- make an option to show password
    // also add links and labels to registration and main logo

    public LoginWindowController() {

    }

    /***
     * This function returns serialized data from this form
     * "login;passwd;rememberMe;"
     */
    public String getData() {
        return loginContent.serialize();
    }

    // from IControllable
    @Override
    public void setScreenParent(ScreensController superController) {

    }
}
