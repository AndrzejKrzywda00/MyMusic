package modelsFX;

import App.Playlist;
import App.Track;
import newTrackWindowConstants.ImagesPaths;

public class ModelConverter {

    /*
    This class is converter for class to its display model
    and reverse
     */

    ImagesPaths imagesPaths = new ImagesPaths();

    public ModelConverter() {

    }

    // Track -> TrackModel
    public TrackModel trackToModel(Track track) {
        TrackModel output = new TrackModel();

        output.setThumbnail(new TableImage().loadImage(track.getThumbnail()));
        output.setTitle(track.getTitle());
        output.setAuthors(track.getAuthor());
        output.setRating(track.getRating().getValue());
        output.setDate(track.getAddedDate());
        output.setSource(track.getSource().toString());
        output.setLength(track.getLengthInString());
        output.setLink(track.getURL());

        return output;
    }

    public PlaylistModel playlistToModel(Playlist playlist) {
        PlaylistModel output = new PlaylistModel();

        // setting up thumbnail - not sure yet how it's going to look
        output.setTitle(playlist.getName());

        return output;
    }

}
