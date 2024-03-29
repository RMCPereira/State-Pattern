/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.Normal;

import java.util.Observable;

/**
 * This class provides an initial model of a carousel door  
 * that manages its state without moving state-specific 
 * logic out to state classes.  
 * @author TookieTookie
 */
public class Door_1 extends Observable {

    public static final int CLOSED = -1;
    public static final int CLOSING = -4;
    public static final int OPEN = -3;
    public static final int OPENING = -2;
    //   
    private int state = CLOSED;
    public static final int STAYOPEN = -5;

    /**  
     * The carousel user has clicked the carousel button. This "one  
     * touch" button elicits different behaviors, depending on the  
     * state of the door.  
     */
    public void click() {
        if (state == CLOSED) {
            setState(OPENING);
        } else if (state == OPENING || state == STAYOPEN) {
            setState(CLOSING);
        } else if (state == OPEN) {
            setState(STAYOPEN);
        } else if (state == CLOSING) {
            setState(OPENING);
        }
    }

    /**  
     * This is a notification from the mechanical carousel that the  
     * door finished opening or shutting.  
     */
    public void complete() {
        if (state == OPENING) {
            setState(OPEN);
        } else if (state == CLOSING) {
            setState(CLOSED);
        }
    }

    private void setState(int state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }

    /**  
     * Return a textual description of the door's state.  
     *  
     * @return a textual description of the door's state  
     */
    public String status() {
        switch (state) {
            case OPENING:
                return "Opening";
            case OPEN:
                return "Open";
            case CLOSING:
                return "Closing";
            case STAYOPEN:
                return "StayOpen";
            default:
                return "Closed";
        }
    }

    /**  
     * This is a notification from the mechanical carousel that the  
     * door got tired of being open.  
     */
    public void timeout() {
        setState(CLOSING);
    }
}
