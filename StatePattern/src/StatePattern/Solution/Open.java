/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern.Solution;

/**
 *
 * @author TookieTookie
 */
public class Open extends State{

    public Open(Order os) {
        super(os);
    }

    @Override
    public void insertService(Service service) {
        os.getServices().add(service);
        os.setState(os.getOpen());
    }

    @Override
    public void removeService(Service service) {
    }

    @Override
    public void requestPayment() {
    }

    @Override
    public void cancelOS() {
    }
    
    
    
    
    
}
