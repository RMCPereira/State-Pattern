/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.State_Pattern;

/**
 * Model the behavior of a carousel door when it's closing.
 * @author TookieTookie
 */
public class DoorClosing extends DoorState {

    /**  
     * Construct a state for the provided door.  
     */
    public DoorClosing(Door_2 door) {
        super(door);
    }

    /**  
     * Stop closing and start opening the door.  
     */
    @Override
    public void click() {
        door.setState(door.OPENING);
    }

    /**  
     * Switch the state to CLOSED.  
     */
    @Override
    public void complete() {
        door.setState(door.CLOSED);
    }
}
