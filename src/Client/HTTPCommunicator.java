package Client;

import Client.Utils.Request;
import Client.Utils.Response;
import Client.Utils.StandardDataPiece;
import Client.Utils.enums.Headers;
import Client.Utils.enums.Methods;
import Client.Utils.interfaces.IAccessHttpClient;
import JavaFX.controller.AddTrackMenuController;
import JavaFX.controller.ArchivizeFromNetController;
import JavaFX.controller.LoginWindowController;
import JavaFX.controller.TracksListController;
import enums.MessageType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HTTPCommunicator implements IAccessHttpClient, HttpClient.HTTPResponseHandler {

    /*
    This class provides with functionality to connect controllers with
    HTTPClient

    It builds requests on behalf of controllers data
    And calls appropriate functions of HttpClient class

    On the other side passess data from responses to controlllers
    And they react
     */

    private static HTTPCommunicator INSTANCE = new HTTPCommunicator();

    private HTTPCommunicator() {

    }

    public static HTTPCommunicator getInstance() {
        return INSTANCE;
    }

    // controllers encapsulation
    private AddTrackMenuController addC;
    private LoginWindowController loginC;
    private ArchivizeFromNetController archC;
    private TracksListController tracksC;

    // http client encapsulation
    HttpClient client = new HttpClient();   // this should probably be singleton as well

    // my data fields
    // these headers are important, content-dependent ones
    private Map<String, String> headers = new HashMap<String, String>();

    // registration methods
    public void registerAddTrackMenuController(AddTrackMenuController c) {
        addC = c;
    }

    public void registerLoginWindowController(LoginWindowController c) {
        loginC = c;
    }

    public void registerTracksListController(TracksListController c) {
        tracksC = c;
    }

    public void registerArchivizeFromNetController(ArchivizeFromNetController c) {
        archC = c;
    }

    private void fillHeaders(MessageType type, String body) {

        // putting in headers all necessary data
        headers.put(Headers.ContentType.name, type.name);
        headers.put(Headers.ContentLength.name, String.valueOf(body.length()));
    }

    @Override
    public void sendRequest(Request request, HttpClient.HTTPResponseHandler handler) {
        client.send(request, handler);
    }

    @Override
    public void passRequest(Methods method, String URI, MessageType type, String body) {

        Request request = new Request();        // here loading default headers
        request.setMethod(method);
        request.setURI(URI);

        fillHeaders(type, body);
        request.loadHeaders(headers);           // here loading all other headers - in case of login special header will be appended

        request.setBody(body);

        sendRequest(request, this);      // calling send method on HTTPClient
    }

    @Override
    public void forwardDataPackage(StandardDataPiece data) {

    }

    @Override
    public void forwardAuthorizationData(StandardDataPiece data) {

    }

    // procedes to make actions to inform the app
    @Override
    public void procedeResponse(Response response) {
        // depending on the headers make decision
        // which function will be called
    }
}
