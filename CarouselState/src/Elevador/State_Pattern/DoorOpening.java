/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.State_Pattern;

/**
 * Model the behavior of a carousel door when it's opening.
 * @author TookieTookie
 */
public class DoorOpening extends DoorState {

    /**  
     * Construct a state for the provided door.  
     */
    public DoorOpening(Door_2 door) {
        super(door);
    }

    /**  
     * Stop opening and start closing the door.  
     */
    @Override
    public void click() {
        door.setState(door.CLOSING);
    }

    /**  
     * Switch the state to OPEN.  
     */
    @Override
    public void complete() {
        door.setState(door.OPEN);
    }
}
