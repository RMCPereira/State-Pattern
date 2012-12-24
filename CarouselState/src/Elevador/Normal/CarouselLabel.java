/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.Normal;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * Show the state of a carousel, in a label.
 * @author TookieTookie
 * @see ShowCarousel
 */
public class CarouselLabel extends JLabel implements Observer {

    /**  
     * Set the text of the label to indicate the carousel's  
     * state, and repaint when the carousel changes.  
     */
    @Override
    public void update(Observable o, Object arg) {
        setText(carousel.status());
        repaint();
    }
    private Carousel carousel;

    /**  
     * Construct a label that will observe the provided carousel.  
     */
    public CarouselLabel(Carousel carousel) {
        this.carousel = carousel;
        setText(carousel.status());
        carousel.addObserver(this);
        setForeground(java.awt.Color.black);
    }
}
