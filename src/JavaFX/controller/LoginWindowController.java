package JavaFX.controller;

//import com.sun.javafx.geom.Rectangle;
import LoginWindowConstants.LoginButtonColors;
import LoginWindowConstants.LoginStrings;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginWindowController {

    // TODO -- fill string magic values with proper resource bundles in two languages

    private Color defaultLogin;
    private Color defaultRegistration;

    private String password = "jebacpis";
    private String login = "Andrzej";

    private LoginStrings stringContens = new LoginStrings();
    private LoginButtonColors colorProbe = new LoginButtonColors();

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
    TextField loginTextField;

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

        rememberMeButton.setOnAction( e -> {
            int newOpacity = tickRememberMe.getOpacity() == colorProbe.INVISIBLE ? colorProbe.FULLY_VISIBLE : colorProbe.INVISIBLE;
            tickRememberMe.setOpacity(newOpacity);
        });
    }

    @FXML
    void loginButtonClicked() {
        /* Parse data and check if it is correct */
        if ( password.equals(passwordTextField.getText()) && login.equals(loginTextField.getText())) {
            // logged in successfully
        }
        else {
            // type informationa ab. wrong pasword or worng email using new fxml file
            loginFailedPane.setOpacity(colorProbe.FULLY_VISIBLE);
            loginTextRectangle.setStroke(colorProbe.WRONG_DATA_RED);
            loginTextRectangle.setStrokeWidth(colorProbe.WIDTH);
            passwordTextRectangle.setStroke(colorProbe.WRONG_DATA_RED);
            passwordTextRectangle.setStrokeWidth(colorProbe.WIDTH);
        }
        passwordTextField.setText(stringContens.EMPTY_STRING);
        loginTextField.setText(stringContens.EMPTY_STRING);
    }

    @FXML
    void loginButtonEntered() {
        loginRectangle.setFill(colorProbe.LOGIN_ACTIVE);
    }

    @FXML
    void loginButtonExited() {
        loginRectangle.setFill(colorProbe.LOGIN_INACTIVE);
    }

    @FXML
    void registerButtonEntered() {
        registrationRectangle.setFill(colorProbe.REGISTER_ACTIVE);
    }

    @FXML
    void registerButtonExited() {
        registrationRectangle.setFill(colorProbe.REGISTER_INACTIVE);
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
