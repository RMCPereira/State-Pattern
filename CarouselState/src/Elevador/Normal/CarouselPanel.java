/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.Normal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 * Portray a carousel's door.
 * @author TookieTookie
 * @see ShowCarousel
 */
public class CarouselPanel extends JPanel implements Observer {

    private Carousel carousel;

    /**  
     * Construct a panel that will portray a carousel's  
     * door.  
     */
    public CarouselPanel(Carousel carousel) {
        this.carousel = carousel;
        carousel.addObserver(this);
        setPreferredSize(new Dimension(300, 100));
    }

    /**  
     * Repaint the panel when the observed carousel changes.  
     */
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        int extent = (int) (w * carousel.getPercentClosed());
        g.setColor(Color.yellow);
        g.fillRect(0, 0, extent, h);
        g.setColor(Color.black);
        g.fillRect(extent, 0, w, h);
    }
}
