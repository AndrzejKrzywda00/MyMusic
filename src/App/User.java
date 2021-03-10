package App;

import Interfaces.ITextSerializeable;
import javafx.scene.image.Image;

public class User implements ITextSerializeable {

    // This class holds all information related to user of the app
    // All this data is obtained from server after successfull logging

    private String name;            // just the choosen name, will be displayed on the side exapanded menu
    private String login;           // the login, choosen during registration, also displayed
    private Image avatar;           // avatar, also displayed
    private String description;     // rather short one
    private ID uniqueID;            // added via server

    public String getName() { return this.name; }

    public String getLogin() { return this.login; }

    public Image getAvatar() { return  this.avatar; }

    public String getDescription() { return this.description; }

    public String getID() {
        return this.uniqueID.toString();
    }

    public String serialize() {
        StringBuilder output = new StringBuilder();

        output.append(name);
        output.append(";");
        output.append(login);
        output.append(";");
        output.append(description);
        output.append(";");
        output.append(uniqueID.serialize());

        return output.toString();
    }

    public void importData(String name, String login, Image avatar, String description, ID uniqueID) {
        this.name = name;
        this.login = login;
        this.description = description;
        this.avatar = avatar;
        this.uniqueID = uniqueID;
    }

}
