package enums;

public enum Phase {

    // this class informs application in which stage is it

    // phases
    Logged(1,"logged"),
    NotLogged(2,"not logged");

    // properties
    public final int index;
    public final String phase;

    Phase(int index, String phase) {
        this.index = index;
        this.phase = phase;
    }
}
