package JavaFX.controller;

//import com.sun.javafx.geom.Rectangle;
import Colors.LoginButtonColors;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginWindowController {

    private Color defaultLogin;
    private Color defaultRegistration;

    private String password = "jebacpis";
    private String login = "Andrzej";

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

    void initialize() {
    }

    @FXML
    void loginButtonClicked() {
        /* Parse data and check if it is correct */
        if ( password.equals(passwordTextField.getText()) && login.equals(loginTextField.getText())) {
            System.out.println("Udało się zalogować do systemu!");
            
        }
        else {
            System.out.println("Odmowa dostępu!");
        }
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

    // TODO -- connetct my two windows with some logic

    public LoginWindowController() {

    }

}
