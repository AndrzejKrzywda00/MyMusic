package App.Utils;

import App.Track;
import enums.Rating;

import static java.lang.Integer.valueOf;

public class TrackBuilder {

    /*
    This is builder class for Track component
     */

    Track track;    // instace of track to be created

    // limits
    private int textLimit = 200;

    public TrackBuilder() {
        track = new Track();
    }

    public TrackBuilder setTitle(String title) {
        if (title.length() <= textLimit) {
            track.setTitle(title);
        }
        return this;
    }

    public TrackBuilder setAuthor(String author) {
        if (author.length() <= textLimit) {
            track.setAuthor(author);
        }
        return this;
    }

    public TrackBuilder setURL(String URL) {
        if(URL.length() <= 3 * textLimit) {
            track.setURL(URL);
        }
        return this;
    }

    public TrackBuilder setLength(String length) {

        // to be corrected yet

        int output = 0;
        // length is string in format hh:mm:ss
        // so first it needs to be parsed
        // we are guaranteed here that it isn't empty string
        String[] sections = length.split(":",2);

        int[] timeSections = new int[3];
        for( int i=0; i<sections.length; i++ ) {
            if (sections[i] == "") {
                timeSections[i] = 0;
            }
            else {
                try {
                    timeSections[i] = Integer.parseInt(sections[i]);
                } catch (NumberFormatException e) {
                    System.out.println("There was a problem passing the time");
                }

            }
        }

        if (timeSections[1] <= 60 && timeSections[2] <= 60) {
            output = timeSections[0] * 3600 + timeSections[1] * 60 + timeSections[2];
        }
        if (output > 0) {
            track.setLength(output);
        }
        return this;
    }

    public TrackBuilder setFormat(String format) {
        if(format.length() <= textLimit) {
            track.setFormat(format);
        }
        return this;
    }

    public TrackBuilder setRating(int rating) {
        Rating parsedRating = Rating.getRating(rating);
        if(parsedRating != null) {
            track.setRating(parsedRating);
        }
        return this;
    }

    public TrackBuilder setDescription(String description) {
        if(description.length() <= textLimit) {
            track.setDescription(description);
        }
        return this;
    }

    public TrackBuilder setThumbnail(String thumbnail) {
        if(thumbnail != null && thumbnail.length() <= 3 * textLimit) {
            track.setThumbnail(thumbnail);
        }
        return this;
    }

    public Track getTrack() {
        return this.track;
    }

}
