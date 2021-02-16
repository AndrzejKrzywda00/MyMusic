package Interfaces;

public interface IObserver {

    // This interface is implementation of type that can make class observe
    // Also a part of Observer design pattern

    /***
     * Sets the right fields in the class
     * @return  true if operataion has been successfull, false otherwise
     */
    public Boolean update();

}
