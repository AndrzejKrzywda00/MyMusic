package App.Utils;

import App.Playlist;

public class PlaylistBuilder {

    /*
    This is a builder for a playlist object
     */

    private Playlist playlist;

    public PlaylistBuilder() {

    }

    public PlaylistBuilder setName(String name) {
        if (name != null) {
            playlist.setName(name);
        }
        return this;
    }

    public PlaylistBuilder setDescription(String description) {
        if (description != null) {
            playlist.setDescription(description);
        }
        return this;
    }



}
