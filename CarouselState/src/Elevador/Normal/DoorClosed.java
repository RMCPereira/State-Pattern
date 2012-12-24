/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.Normal;

import Elevador.Normal.Door;

/**
 * Model the behavior of a carousel door when it's closed. This  
 * refactoring uses constant state values.
 * @author TookieTookie
 */
public class DoorClosed extends DoorState {

    /**  
     * Open the door.  
     */
    @Override
    public void click(Door door) {
        door.setState(OPENING);
    }
}
