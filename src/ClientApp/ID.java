package ClientApp;

import java.util.UUID;

public class ID {

    // Here is the unique id of a track that will only be used in frontend app.
    public final static String NOT_IMPLEMENTED = "not implemented";

    private String content = NOT_IMPLEMENTED;

    ID() {
        this.content = generateID();
    }

    String generateID() {
        /* Will generate random unique id for a track */
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }

}
