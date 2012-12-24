/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.Normal;

import Elevador.Normal.Door;

/**
 * Model the behavior of a carousel door when it's open. This  
 * refactoring uses constant state values.
 * @author TookieTookie
 */
public class DoorOpen extends DoorState {

    /**  
     * Stay open until another click comes along.  
     */
    @Override
    public void click(Door door) {
        door.setState(STAYOPEN);
    }

    /**  
     * Insert the method's description here.  
     * Creation date: (5/15/01 12:30:54 PM)  
     * @param args java.lang.String[]  
     */
    @Override
    public void timeout(Door door) {
        door.setState(Door.CLOSING);
    }
}
