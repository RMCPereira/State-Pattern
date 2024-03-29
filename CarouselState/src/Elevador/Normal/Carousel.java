/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.Normal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

/**  
 * Model the behavior of a carousel, the machine that will  
 * send our door object clicks.  
 *   
 * @author TookieTookie  
 * @see ShowCarousel  
 */
public class Carousel extends Observable implements ActionListener {

    private double percentClosed = 1.00;
    private Timer heartbeatTimer;
    private Timer timeoutTimer;
    // Carousel uses the following states, not to be confused    
    // with ones we create for the Door classes; Carousel is    
    // a black box to us   
    public static final int CLOSED = -1;
    public static final int OPENING = -2;
    public static final int OPEN = -3;
    public static final int CLOSING = -4;
    public static final int STAYOPEN = -5;
    //Initial State
    private int state = CLOSED;

    /**  
     * Respond to one of two timers, our heartbeat or the  
     * timeout timer.  
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(heartbeatTimer())) {
            heartbeat();
        }
        if (source.equals(timeoutTimer())) {
            timeout();
        }
    }

    /**  
     * The user clicked our button. React accordingly  
     * and let the Door object know.  
     */
    public void click() {
        if (state == CLOSED) {
            this.state = OPENING;
        } else if (state == OPENING || state == STAYOPEN) {
            this.state = CLOSING;
        } else if (state == OPEN) {
            this.state = STAYOPEN;
            timeoutTimer.stop();
        } else if (state == CLOSING) {
            this.state = OPENING;
        }
        setChanged();
        notifyObservers();
    }

    /**  
     * Return a percentage showing how closed the  
     * door is.  
     */
    public double getPercentClosed() {
        return percentClosed;
    }
    /*  
     * Update the simulated door.  
     */

    private void heartbeat() {
        if (state == OPENING) {
            incrementPercentClosed(-.04);
            //incrementPercentClosed(-.1);
            if (percentClosed <= 0.01) {
                this.state = OPEN;
                timeoutTimer().start();
            }
        } else if (state == CLOSING) {
            incrementPercentClosed(.04);
            //incrementPercentClosed(.1);
            if (percentClosed >= 0.99) {
                this.state = CLOSED;
            }
        }
    }
    /*  
     * This timer makes the carousel seem alive.  
     */

    private Timer heartbeatTimer() {
        if (heartbeatTimer == null) {
            heartbeatTimer = new Timer(400, this);
        }
        return heartbeatTimer;
    }

    private void incrementPercentClosed(double inc) {
        percentClosed += inc;
        percentClosed = Math.min(1.0, percentClosed);
        percentClosed = Math.max(0.0, percentClosed);
        if (percentClosed >= 0.99) {
            state = CLOSED;
        } else if (percentClosed == 0.01) {
            state = OPEN;
        }
        setChanged();
        notifyObservers();
    }

    /**  
     * Start the timer that makes a carousel object  
     * monitor the state of its door.  
     */
    public void start() {
        heartbeatTimer().start();
    }
    /*  
     * We got bored standing around with our door open.  
     */

    private void timeout() {
        state = CLOSING;
        setChanged();
        notifyObservers();
    }

    /**  
     * Insert the method's description here.   
     * @param args java.lang.String[]  
     */
    private Timer timeoutTimer() {
        if (timeoutTimer == null) {
            timeoutTimer = new Timer(2000, this);
            timeoutTimer.setRepeats(false);
        }
        return timeoutTimer;
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
}
