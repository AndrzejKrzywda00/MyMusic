package Client.Utils.enums;

public enum Methods {

    // all HTTP methods
    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    CONNECT("CONNECT"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE"),
    PATCH("PATCH");

    public final String name;

    Methods(String name) {
        this.name = name;
    }

}
