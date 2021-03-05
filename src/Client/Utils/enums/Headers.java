package Client.Utils.enums;

public enum Headers {

    userID("userID"),                       // standard auth in every process
    login("login"),                         // has two header fields

    ContentType("Content-Type"),            // first 'official' header - this one will indicate login iformation
    ContentLength("Content-Length"),        // indicates length of body in chars
    Date("Date");

    public String name;

    Headers(String name) {
        this.name = name;
    }

}
