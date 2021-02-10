package ClientApp;

import javafx.scene.image.Image;

public class User {

    // This class holds all information related to user of the app
    // All this data is obtained from server after successfull logging

    private String name;
    private String login;
    private Image avatar;

    public String getName() {
        return this.name;
    }

    public String getLogin() {
        return this.login;
    }

}
