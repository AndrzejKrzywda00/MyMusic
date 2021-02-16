package ClientApp;

import Interfaces.IObservable;
import Interfaces.IObserver;
import enums.Phase;
import javafx.stage.Stage;

import java.util.ArrayList;

public final class PhaseSynchronizer implements IObservable {

    // this class will sychronize changes between two accessible states of an app
    // which are Logged and NotLogged
    // it consists of thread that listes to changes in loginWindow and in mainWindow

    // this is singleton pattern as well

    private static final PhaseSynchronizer INSTANCE = new PhaseSynchronizer();

    // list contains all classes that will be notified when state of this app is changed
    private ArrayList<IObserver> subscribers = new ArrayList<IObserver>();

    // properties
    private Phase phase;

    private PhaseSynchronizer() {
        this.phase = Phase.NotLogged;   // be default user is not logged
    }

    public static PhaseSynchronizer getInstance() {
        return INSTANCE;
    }

    /***
     * Sets phase of application to logged
     */
    public void setLoggedPhase() {
        this.phase = Phase.Logged;
    }

    /***
     * Sets phase of application to not logged
     */
    public void setNotLoggedPhase() {
        this.phase = Phase.NotLogged;
    }

    // phase getter
    public Phase getPhase() {
        return this.phase;
    }   // this satisfies getState() method from design pattern

    /*
    Contenent of IObservable interface
     */

    @Override
    public void add(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void remove(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyObservers() {
        for (IObserver subscriber : subscribers) {
            subscriber.update();    // trigger somebodys function update
        }
    }

}
