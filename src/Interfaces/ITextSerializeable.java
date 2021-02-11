package Interfaces;

public interface ITextSerializeable {

    /* as name suggests this interface is to force serialization */

    /***
     * Takes content of any object and converts it's whole state (state of all properties) into String
     * As separator, the method is using ';'
     * The sequence of properties is as are they are declared in the class
     * @return Returns completely serialized object
     */
    public String serialize();  // not entirely sure if this sholud have String or StringBuilder

}
