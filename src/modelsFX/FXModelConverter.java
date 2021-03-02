package modelsFX;

import App.Playlist;
import App.Track;
import newTrackWindowConstants.ImagesPaths;

public class FXModelConverter {

    /*
    This class is converter for class to its display model
    and reverse
     */

    ImagesPaths imagesPaths = new ImagesPaths();

    public FXModelConverter() {

    }

    // Track -> TrackModel
    public TrackFX trackToModel(Track track) {
        TrackFX output = new TrackFX();

        output.setThumbnail(new TableImageFX().loadImage(track.getThumbnail()));
        output.setTitle(track.getTitle());
        output.setAuthors(track.getAuthor());
        output.setRating(track.getRating().getValue());
        output.setDate(track.getAddedDate());
        output.setSource(track.getSource().toString());
        output.setLength(track.getLengthInString());
        output.setLink(track.getURL());

        return output;
    }

    public PlaylistFX playlistToModel(Playlist playlist) {
        PlaylistFX output = new PlaylistFX();

        // setting up thumbnail - not sure yet how it's going to look
        output.setTitle(playlist.getName());

        return output;
    }

}
