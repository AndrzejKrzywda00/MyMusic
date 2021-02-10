package ClientApp;

import enums.Phase;

public final class PhaseSynchronizer {

    // this class will sychronize changes between two accessible states of an app
    // which are Logged and NotLogged
    // it consists of thread that listes to changes in loginWindow and in mainWindow

    // this is singleton pattern as well

    private static final PhaseSynchronizer INSTANCE = new PhaseSynchronizer();

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

}
