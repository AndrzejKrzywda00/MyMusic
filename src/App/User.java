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
    private ID uniqueID;

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

    public void importData(String name, String login, String description, ID uniqueID) {
        this.name = name;
        this.login = login;
        this.description = description;
        this.uniqueID = uniqueID;
    }

}
