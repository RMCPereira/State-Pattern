/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador;

import Elevador.Normal.Carousel;
import Elevador.Normal.CarouselLabel;
import Elevador.Normal.CarouselPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Shows what the carousel door looks like. The "One Touch"  
 * button changes the state of the door, depending on the  
 * current state. See the "State" chapter of "The Design  
 * Patterns Java Workbook" for details.
 * @author TookieTookie
 */
public class ShowCarousel implements ActionListener {

    private Box buttonBox;
    private CarouselPanel doorPanel;
    private JPanel mainPanel;

    /**  
     * Let the carousel know that someone pushed its button.  
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        carousel.click();
    }
    /*  
     * A container for the status label and the "One Touch"  
     * button.  
     */

    protected Box buttonBox() {
        if (buttonBox == null) {
            buttonBox = Box.createHorizontalBox();
            buttonBox.add(status());
            buttonBox.add(Box.createHorizontalGlue());
            buttonBox.add(button());
        }
        return buttonBox;
    }

    /**  
     * Shows what the carousel door looks like.    
     */
    public static void main(String[] args) {
        ShowCarousel app = new ShowCarousel();
        JFrame launch = SwingFacade.launch(app.mainPanel(), "State Pattern - Elevador (Sem State Pattern)");
        app.start();
        launch.setVisible(true);
               
    }
    /*  
     * The panel that contains all the GUI components.   
     */

    protected JPanel mainPanel() {
        if (mainPanel == null) {
            mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            mainPanel.add(doorPanel());
            mainPanel.add(buttonBox(), "South");
        }
        return mainPanel;
    }
    private JButton button;
    private Carousel carousel = new Carousel();
    //private Carousel_2 carousel = new Carousel_2();
    private JLabel status;

    protected JButton button() {
        if (button == null) {
            button = new JButton("Click me!");
            button.addActionListener(this);
        }
        return button;
    }

    protected void start() {
        carousel.start();
    }

    protected JLabel status() {
        if (status == null) {
            status = new CarouselLabel(carousel);
        }
        return status;
    }

    protected CarouselPanel doorPanel() {
        if (doorPanel == null) {
            doorPanel = new CarouselPanel(carousel);
        }
        return doorPanel;
    }
}
