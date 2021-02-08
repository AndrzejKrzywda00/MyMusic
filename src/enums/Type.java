package enums;

public enum Type {
    
    // Showing the information about certain specific sources

    // Web resources
    YouTube(1,"youtube"),
    Spotify(2,"spotify"),
    SoundCloud(3,"soundcloud"),
    BandCamp(4,"bandcamp"),

    // Local path
    LocalPath(5,"localpath"),

    // other - for special situations
    Other(6,"other");

    public final int index;
    public final String description;

    /***
     *
     * @param index         Information about index set to this source type
     * @param description   Name of the source type
     */
    Type(int index, String description) {
        this.index = index;
        this.description = description;
    }
    
}
