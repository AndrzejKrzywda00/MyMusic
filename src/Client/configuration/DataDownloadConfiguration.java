package Client.configuration;

public class DataDownloadConfiguration {

    public static final String address = "127.0.0.1";
    public static final int port = 1234;

    public static final int DISPLAY_CAPASITY = 200;     // this is maximum of how many tracks will be downloaded

    // data will be taken on demand from server
    // request will be built
    // written to a web socket
    // and we wait for response

}
