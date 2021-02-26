package App;

import Interfaces.ITextSerializeable;
import enums.Type;

public class Source implements ITextSerializeable {

    // Holds all information about source of the file.

    // First it has a link leading directly to the track stored in String.
    // it can be a local file like "C:\Users\akrzy\OneDrive\Pictures\Saved Pictures\60fzp7iigky41"
    // or it can be a URL to web asset "https://www.youtube.com/watch?v=_bcMeNMvue4&ab_channel=TacoHemingway"

    // Second it has type of source which is an enum.
    // For exmple:

    private String link;        // Direct link to some resource
    private Type type;          // Forshadowing usage of certain enum type
    private Boolean isActive;   // Information whether it is accessible

    // getters
    public Boolean getIsActive() { return this.isActive; }
    public String getLink() { return this.link; }
    public Type getType() { return this.type; }

    // TODO -- automatize this -- bond links with types
    /***
     * Used when URL is local path - so there we know if path is accessible
     * @param link          only local link
     * @param type          type of link (should be local)
     * @param isActive      should be set as true (but let it to me for now)
     */
    public Source(String link, Type type, Boolean isActive) {
        this.link = link;
        this.type = type;
        this.isActive = isActive;
    }

    /***
     * Used when URL is not local - so there we don't know of the path is accessible
     * @param link          only remote link
     * @param type          should be remote type
     */
    public Source(String link, Type type) {
        this.link = link;
        this.type = type;
    }

    public void setLinkActivity(Boolean isActive) {
        this.isActive = isActive;
    }

    public String serialize() {
        StringBuilder output = new StringBuilder();

        output.append(link);
        output.append(";");
        output.append(type);
        output.append(";");
        output.append(isActive);
        output.append(";");

        return output.toString();
    }

    public String toString() {
        return type.toString();
    }
}
