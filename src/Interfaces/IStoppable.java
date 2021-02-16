package Interfaces;

public interface IStoppable {

    // this interface is used to manage threads in java apps
    // not necessarly of this application but can be utilized later

    /***
     * Should set Thread status to willing to stop
     */
    public void requestStop();

    /***
     * Sholud return info whether stop has been requested
     */
    public Boolean isStopRequested();
}
