package enums;

public enum Phase {

    // this class informs application in which stage is it

    // phases
    Logged(1,"logged"),
    NotLogged(2,"not logged");

    // properties
    public final int index;

    public String getPhaseName() {
        return phaseName;
    }

    public final String phaseName;

    Phase(int index, String phaseName) {
        this.index = index;
        this.phaseName = phaseName;
    }
}
