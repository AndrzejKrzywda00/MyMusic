package Client;

import Client.Utils.IAccessHttpClient;
import JavaFX.controller.AddTrackMenuController;
import JavaFX.controller.ArchivizeFromNetController;
import JavaFX.controller.LoginWindowController;
import JavaFX.controller.TracksListController;

public class HTTPCommunicator implements IAccessHttpClient {

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
    public void buildRequest() {

    }

    @Override
    public void forwardDataPackage() {

    }

    @Override
    public void forwardAuthorizationData() {

    }


}
