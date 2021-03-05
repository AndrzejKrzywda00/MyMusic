package Client;

import Client.Utils.Request;
import Client.Utils.Response;
import Client.Utils.enums.Methods;
import Client.Utils.interfaces.IAccessHttpClient;
import JavaFX.controller.AddTrackMenuController;
import JavaFX.controller.ArchivizeFromNetController;
import JavaFX.controller.LoginWindowController;
import JavaFX.controller.TracksListController;

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

    // controllers encapsulation
    private AddTrackMenuController addC;
    private LoginWindowController loginC;
    private ArchivizeFromNetController archC;
    private TracksListController tracksC;

    // http client
    HttpClient client = new HttpClient();   // this should probably be singleton as well


    @Override
    public void sendRequest() {
        // invoke send() on client
    }

    @Override
    public void buildRequest(Methods method, String URI, Map<String, String> headers, String body) {
        Request request = new Request();
        request.setMethod(method);
        request.setURI(URI);
        request.loadHeaders(headers);
        request.setBody(body);

        sendRequest();      // calling send method on HTTPClient
    }

    @Override
    public void forwardDataPackage() {
        
    }

    @Override
    public void forwardAuthorizationData() {

    }

    // procedes to make actions to inform the app
    @Override
    public void procedeResponse(Response response) {

    }
}
