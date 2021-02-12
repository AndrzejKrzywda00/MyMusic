package enums;

import Interfaces.ITextSerializeable;

public enum Origin implements ITextSerializeable {

    // Having here fixed values of origin of all tracks
    // for example file added via built-in creator will have different origin than added via archivising youtube playlist

    // origins
    ManualAddition(1,"manual"),
    ManualArchiving(2,"manual archiving"),
    AutomaticArchiving(3,"automatic archiving"),

    // other - for special situations
    Other(0,"other");

    // properties
    public final int index;
    public final String origin;


    /***
     * @param index     Numeric index of certain origin
     * @param origin    Description of the origin
     */
    Origin(int index, String origin) {
        this.index = index;
        this.origin = origin;
    }

    public String serialize() {
        StringBuilder output = new StringBuilder();
        output.append(index);
        output.append(";");
        return output.toString();
    }

}
