package Interfaces;

public interface IObservable {

    // This interface describes the active behavior of object that can be observed
    // It is also a part of Observer desugn pattern

    /***
     *
     * @param subscriber    Adding subscirber to the list
     * @return              Returns true if operation has been successfull, false otherwise
     */
    public Boolean add(IObserver subscriber);

    /***
     *
     * @param subscriber    Removing this subscriber from the list
     * @return              Returns true if opertaion has been successfull, false otherwise
     */
    public Boolean remove(IObserver subscriber);

    /***
     * Notify all subscribers to the class
     */
    public void notifyObservers();

}
