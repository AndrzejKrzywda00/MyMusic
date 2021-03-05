package Client.configuration;

public class ClientConfiguration {

    private static final String serverAddress = "77.55.214.191";
    private static final int serverPort = 6653;



    private static final int downloadWaitTime = 10;     // seconds
    private static final int uploadWaitTime = 5;        // seconds
    private static final int deleteWaitTime = 10;       // seconds

    public ClientConfiguration(){}

    public static String getAddress() {
        return serverAddress;
    }

    public static int getPort() {
        return serverPort;
    }

    public static int getDownloadWaitTime() {
        return downloadWaitTime;
    }

    public static int getUploadWaitTime() {
        return uploadWaitTime;
    }

    public static int getDeleteWaitTime() {
        return deleteWaitTime;
    }
}
