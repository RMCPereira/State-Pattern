/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.Normal;

import Elevador.Normal.Door;

/**
 * Model the behavior of a carousel door when it's opening. This  
 * refactoring uses constant state values.
 * @author TookieTookie
 */
public class DoorOpening extends DoorState {

    /**  
     * Stop opening and start closing the door.  
     */
    @Override
    public void click(Door door) {
        door.setState(CLOSING);
    }

    /**  
     * Insert the method's description here.  
     * Creation date: (5/15/01 12:30:54 PM)  
     * @param args java.lang.String[]  
     */
    @Override
    public void complete(Door door) {
        door.setState(Door.OPEN);
    }
}
