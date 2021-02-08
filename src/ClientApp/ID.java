package ClientApp;

public class ID {

    // Here is the unique id of a track that will only be used in frontend app.

    String content;

    ID() {
        content = "no id";
        content = generateID();
    }

    String generateID() {
        /* Will generate random unique id for a track */
        String uniqueId = "no generation of id is implemented";
        return uniqueId;
    }

}
