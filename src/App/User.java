package App;

import Interfaces.ITextSerializeable;
import javafx.scene.image.Image;

public class User implements ITextSerializeable {

    // This class holds all information related to user of the app
    // All this data is obtained from server after successfull logging

    private String name;
    private String login;
    private Image avatar;
    private String description;

    public String getName() { return this.name; }

    public String getLogin() { return this.login; }

    public Image getAvatar() { return  this.avatar; }

    public String getDescription() { return this.description; }

    public String serialize() {
        String output = "";
        return output;
    }

}
