/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.State_Pattern;

/**
 * This class is the top of a hierarchy of door state classes.
 * @author TookieTookie
 */
public abstract class DoorState {

    protected Door_2 door;

    /**  
     * Subclasses must decide what to do when the user  
     * clicks the physical carousel button.  
     */
    public abstract void click();

    /**  
     * By default, discard notifications that the door  
     * finished opening or closing.  
     */
    public void complete() {
    }

    /**  
     * Return a textual desciption of this state.  
     *  
     * @return a textual desciption of this state  
     */
    public String status() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf('.') + 1);
    }

    /**  
     * By default, discard notifications that the door  
     * began closing after having been open for a while.  
     */
    public void timeout() {
    }

    /**  
     * Construct a state for the provided door.  
     *  
     * @param Door_2 a door that needs a state model  
     */
    public DoorState(Door_2 door) {
        this.door = door;
    }
}
