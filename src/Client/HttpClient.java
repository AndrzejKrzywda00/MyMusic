package Client;

import Client.Utils.Request;
import Client.Utils.Response;
import Client.configuration.ClientConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
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
        ClientConfiguration configuration = new ClientConfiguration();
        address = configuration.address;
        port = configuration.port;
    }

    /***
     * This interface forces to have method onResponse that takes response as an argument
     */
    public interface HTTPResponseHandler {
        void onResponse(Response response);
    }

    // generates new Thread that calls handling message
    public static void send(Request request, HTTPResponseHandler handler) {
        new Thread( () -> {
            try {
                handleMessage(request, handler);
            } catch (IOException e) {
                System.out.println("Error while sending the message");
            }
        }).start();
    }

    // this packs the data into request and calls send(Request, HTTPResponseHandler)
    public static void send(String URI, String body, HTTPResponseHandler handler) {
        Request request = new Request();
        request.method = "GET";
        request.URI = URI;
        request.body = body;

        send(request, handler);
    }

    /***
     * This function sends request to server
     * @param request is a ready request
     * @param handler is a choosen handler
     * @throws IOException
     */
    private static void handleMessage(Request request, HTTPResponseHandler handler) throws IOException {
        // adding default headers
        for (Map.Entry<String, String> header : defaultHeaders.entrySet()) {
            request.headers.put(header.getKey(), header.getValue());
        }

        Socket serverSocket = new Socket(InetAddress.getByName(address), port);

        OutputStream requestStream = serverSocket.getOutputStream();
        requestStream.write(request.toByteArray());
        serverSocket.shutdownOutput();

        BufferedReader input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream(), StandardCharsets.UTF_8));

        final double waitTime = 10;
        // retries to read data after [d] seconds
        double waitInterval = 0.2;
        // current waittime in seconds
        double waitedFor = 0;
        while(waitedFor < waitTime && !input.ready()) {
            try {
                Thread.sleep((long) waitInterval * 1000);
                waitedFor += waitInterval;
                waitInterval *= 1.5;
            } catch (InterruptedException e) {
                return;
            }
        }

        if(!input.ready()) {
            // no data after 10 seconds. Close socket, leave the function
            serverSocket.close();
            return;
        }

        StringBuilder data = new StringBuilder();
        while(input.ready()) {
            data.append(input.readLine());
            data.append("\n");
        }

        Response response;
        try {
            response = new Response(data.toString());
        } catch (Exception e) {
            System.out.println("Error while parsing a response");
            return;
        }

        serverSocket.close();
        handler.onResponse(response);

    }

}
