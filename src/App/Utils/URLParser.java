package App.Utils;

import enums.Type;

public class URLParser {

    /*
    This class parses URL to Type
     */

    public URLParser() {
    }

    public Type parse(String URL) {
        String[] beginning = URL.split(":",1);
        if (beginning[0] != null) {
            if(beginning[0].length() == 1) {
                // "C://users/akrzy/documents/track.mp3
                return Type.LocalPath;
            }
            if(beginning[0].length() == 5 || beginning[0].length() == 6) {
                // "http://www.youtube.pl"
                // "https://www.spotify.open.pl"
                if(beginning[1] != null) {
                    String[] parts = beginning[0].split(".",2);
                    String siteName = parts[1];

                    switch(siteName) {
                        case("youtube") : return Type.YouTube;
                        case("soundcloud") : return Type.SoundCloud;
                    }

                    siteName = parts[2];

                    switch (siteName) {
                        case("spotify") : return Type.Spotify;
                        case("bandcamp") : return Type.BandCamp;
                    }

                    return Type.Other;
                }
            }
        }
        return null;
    }

}
