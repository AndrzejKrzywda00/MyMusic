package Interfaces;

public interface IStoppable {

    /***
     * Should set Thread status to willing to stop
     */
    public void requestStop();

    /***
     * Sholud return info whether stop has been requested
     */
    public Boolean isStopRequested();
}
