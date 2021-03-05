package Client.Utils.interfaces;

import Client.Utils.enums.Methods;

import java.util.Map;

public interface IAccessHttpClient {

    // methods to make HttpClient on move
    public void sendRequest();
    public void buildRequest(Methods method, String URI, Map<String, String> headers, String body);

    // methods to call on controllers
    public void forwardDataPackage();
    public void forwardAuthorizationData();

}
