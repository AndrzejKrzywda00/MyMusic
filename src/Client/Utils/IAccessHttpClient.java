package Client.Utils;

public interface IAccessHttpClient {

    // methods to make HttpClient on move
    public void sendRequest();
    public void buildRequest();

    // methods to call on controllers
    public void forwardDataPackage();
    public void forwardAuthorizationData();

}
