package ClientApp;

import enums.Type;

public class Source {

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

    // constructor
    public Source() {

        // initializing all necessary information

    }

}
