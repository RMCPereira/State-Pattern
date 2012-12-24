/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.State_Pattern;

/**
 * Model the behavior of a carousel door when it's open.
 * @author TookieTookie
 */
public class DoorOpen extends DoorState {

    /**  
     * Construct a state for the provided door.  
     */
    public DoorOpen(Door_2 door) {
        super(door);
    }

    /**  
     * Stay open until another click comes along.  
     */
    @Override
    public void click() {
        door.setState(door.STAYOPEN);
    }

    /**  
     * Insert the method's description here.  
     * Creation date: (5/15/01 12:30:54 PM)  
     * @param args java.lang.String[]  
     */
    @Override
    public void timeout() {
        door.setState(door.CLOSING);
    }
}
