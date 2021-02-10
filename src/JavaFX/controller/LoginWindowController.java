package JavaFX.controller;

//import com.sun.javafx.geom.Rectangle;
import Colors.LoginButtonColors;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginWindowController {

    private Color defaultLogin;
    private Color defaultRegistration;

    private String password = "jebacpis";
    private String login = "Andrzej";
    private String emptyString = "";

    private LoginButtonColors probe = new LoginButtonColors();

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

    void initialize() {
    }

    @FXML
    void loginButtonClicked() {
        /* Parse data and check if it is correct */
        if ( password.equals(passwordTextField.getText()) && login.equals(loginTextField.getText())) {
            System.out.println("Udało się zalogować do systemu!");

        }
        else {
            // type informationa ab. wrong pasword or worng email using new fxml file
            loginFailedPane.setOpacity(1.0);    // now fully visible
            loginTextRectangle.setStroke(Color.RED);
            loginTextRectangle.setStrokeWidth(2);
            passwordTextRectangle.setStroke(Color.RED);
            passwordTextRectangle.setStrokeWidth(2);
        }
        passwordTextField.setText(emptyString);
        loginTextField.setText(emptyString);
    }

    @FXML
    void loginButtonEntered() {
        loginRectangle.setFill(probe.loginActive);
    }

    @FXML
    void loginButtonExited() {
        loginRectangle.setFill(probe.loginInactive);
    }

    @FXML
    void registerButtonEntered() {
        registrationRectangle.setFill(probe.registerActive);

    }

    @FXML
    void registerButtonExited() {
        registrationRectangle.setFill(probe.registerInactive);
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
