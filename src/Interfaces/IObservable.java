package Interfaces;

import java.util.ArrayList;

public interface IObservable {

    // This interface describes the active behavior of object that can be observed
    // It is also a part of Observer desugn pattern

    /***
     *
     * @param subscriber    Adding subscirber to the list
     */
    public void add(IObserver subscriber);

    /***
     *
     * @param subscriber    Removing this subscriber from the list
     */
    public void remove(IObserver subscriber);

    /***
     * Notify all subscribers to the class
     */
    public void notifyObservers();

}
