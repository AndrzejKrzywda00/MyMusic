package App;

import Interfaces.ITextSerializeable;
import enums.Rating;

import java.util.ArrayList;
import java.util.Map;

public class Playlist implements ITextSerializeable {
    
    /* this class has an amount of tracks to be grupped by some criteria */

    // properties
    private String name;                    // holds name of playlist
    private ArrayList<String> authors;      // list of authors that contribute to this playlist
    private Rating rating;                  // same rating modeling as in track
    private String addedDate;               // holds date of adding certain playlist
    private String description;             // holds description of playlist
    private ArrayList<Track> tracks;        // holds all added tracks
    private ID uniqueID;                    // is the unique id of the playlist
    private int length;                     // summary length of all tracks
    
    // constructor
    public Playlist() {
        
    }
    
    // getters
    public String getName() { return this.name; }
    
    public String getDescription() { return this.description; }
    
    public ArrayList<Track> getTracks() { return this.tracks; }
    
    // other methods
    /***
     *
     * @return Returns Boolean telling if playlist has any tracks
     */
    public Boolean hasNoTracks() {
        Boolean result = tracks.isEmpty();
        return result;
    }

    /***
     *
     * @return  Returns list of thumbnails of all tracks in playlist OR null if there is no tracks on playlist
     */
    public ArrayList<String> getTracksThumbnails() {
        ArrayList<String> thumbnails = null;
        for( Track track : tracks ) {
            String thumbnail = track.getThumbnail();
            thumbnails.add(thumbnail);
        }
        return thumbnails;
    }

    public String serialize() {
        StringBuilder output = new StringBuilder();
        return output.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUniqueID(ID uniqueID) {
        this.uniqueID = uniqueID;
    }
    
}
