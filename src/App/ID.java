package App;

import java.util.UUID;

public class ID {

    private final String content;

    ID() {
        content = UUID.randomUUID().toString();
    }

    public String serialize() {
        StringBuilder output = new StringBuilder();
        output.append(content);
        output.append(";");
        return output.toString();
    }

    public String toString() {
        return content;
    }

}
