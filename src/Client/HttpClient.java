package Client;

import Client.Utils.Response;

import java.util.HashMap;
import java.util.Map;

public class HttpClient {

    /*
    This class manages communication with HttpServer running on public ip address
     */

    public static final Map<String, String> defaultHeaders = new HashMap<String, String>();
    private static String address;
    private static int port;

    public HttpClient() {

    }

    public interface HTTPResponseHandler {
        void onResponse(Response response);
    }


}
