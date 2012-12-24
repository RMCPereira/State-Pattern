/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.Normal;

import Elevador.Normal.Door;

/**
 * This class is the top of a hierarchy of door state  
 * classes. The hierarchy is refactored from an earlier  
 * version; this version makes door states constant.  
 * @author TookieTookie
 */
public abstract class DoorState implements DoorConstants {

    /**  
     * Subclasses must decide what to do when the user  
     * clicks the physical carousel button.  
     */
    public abstract void click(Door door);

    /**  
     * By default, discard notifications that the door  
     * finished opening or closing.  
     */
    public void complete(Door door) {
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
    public void timeout(Door door) {
    }
}
    