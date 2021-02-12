package ClientApp;

import Interfaces.ITextSerializeable;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Playlist implements ITextSerializeable {
    
    /* this class has an amount of tracks to be grupped by some criteria */
    
    // properties
    private String name;                // holds name of playlist
    private String description;         // holds description of playlist
    private ArrayList<Track> tracks;    // holds all added tracks
    private ID uniqueID;                // is the unique id of the playlist
    
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
    public ArrayList<Image> getTracksThumbnails() {
        ArrayList<Image> thumbnails = null;
        for( Track track : tracks ) {
            Image thumbnail = track.getThumbnail();
            thumbnails.add(thumbnail);
        }
        return thumbnails;
    }

    public String serialize() {
        StringBuilder output = new StringBuilder();
        return output.toString();
    }
    
}
