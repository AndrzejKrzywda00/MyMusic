package Client.Utils.interfaces;

import Client.HttpClient;
import Client.Utils.Request;
import Client.Utils.StandardDataPiece;
import Client.Utils.enums.Methods;
import enums.MessageType;

import java.util.Map;

public interface IAccessHttpClient {

    // methods to make HttpClient on move
    public void sendRequest(Request request, HttpClient.HTTPResponseHandler handler);
    public void passRequest(Methods method, String URI, MessageType type, String body);

    // methods to call on controllers
    public void forwardDataPackage(StandardDataPiece data);
    public void forwardAuthorizationData(StandardDataPiece data);

}
