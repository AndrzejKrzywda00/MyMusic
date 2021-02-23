package App.DataContent;

import Interfaces.ITextSerializeable;

public class LoginContent implements ITextSerializeable {

    // this class encapsulates logging data for single logging

    // content
    private String loginText;
    private String passwordText;
    private Boolean rememberMe;

    @Override
    public String serialize() {

        StringBuilder output = new StringBuilder();

        output.append(loginText);
        output.append(";");
        output.append(passwordText);
        output.append(";");
        output.append(rememberMe.toString());
        output.append(";");

        return output.toString();
    }

    /***
     *
     * @param loginText     Content of the login
     * @param passwordText  Content of the password
     * @param rememberMe    Information login and password should be kept locally to be automatically used next time
     */
    public void getAllData(String loginText, String passwordText, Boolean rememberMe) {
        this.loginText = loginText;
        this.passwordText = passwordText;
        this.rememberMe = rememberMe;
    }

}
