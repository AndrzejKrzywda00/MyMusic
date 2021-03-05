package enums;

public enum MessageType {

    LoginMessage("login message"),
    NewTrackMessage("new track"),
    NewPlaylistMessage("new playlist"),
    TracksDataMessage("tracks data");

    public String name;

    MessageType(String name) {
        this.name = name;
    }

}
