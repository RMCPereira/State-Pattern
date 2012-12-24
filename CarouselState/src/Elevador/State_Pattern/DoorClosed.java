/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.State_Pattern;

/**
 * Model the behavior of a carousel door when it's closed.
 * @author TookieTookie
 */
public class DoorClosed extends DoorState {

    /**  
     * Construct a state for the provided door.  
     */
    public DoorClosed(Door_2 door) {
        super(door);
    }

    /**  
     * Open the door.  
     */
    @Override
    public void click() {
        door.setState(door.OPENING);
    }
}
