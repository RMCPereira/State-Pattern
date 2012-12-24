/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.State_Pattern;

/**
 * Model the behavior of a carousel door when it's been  
 * asked (through a double-click) to stay open. 
 * @author TookieTookie
 */
public class DoorStayOpen extends DoorState {

    /**  
     * Construct a state for the provided door.  
     */
    public DoorStayOpen(Door_2 door) {
        super(door);
    }

    /**  
     * Close the door.  
     */
    @Override
    public void click() {
        door.setState(door.CLOSING);
    }
}
