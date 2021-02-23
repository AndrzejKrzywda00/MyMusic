package App.DataContent;

import App.Playlist;
import App.Track;
import Interfaces.ITextSerializeable;

import java.util.List;

public class AppDataContent implements ITextSerializeable {

    /* this class encapsulates all data from whole application
    Precisely it has list of all tracks and list of all playlists
    This means that some of the tracks are doubled
    This need to change in future
     */

    // all the playlists
    List<Playlist> playlists;

    // all the tracks
    List<Track> tracks;

    public String serialize() {

        StringBuilder output = new StringBuilder();

        // make a strategy of how to serialize it

        return output.toString();
    }

}
