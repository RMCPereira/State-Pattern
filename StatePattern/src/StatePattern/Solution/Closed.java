/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern.Solution;

/**
 *
 * @author TookieTookie
 */
class Closed extends State {

    public Closed(Order os) {
        super(os);
    }

    @Override
    public void insertService(Service service) {
        os.getServices().add(service);
        os.setState(os.getOpen());
    }

    @Override
    public void removeService(Service service) {
        os.getServices().remove(service);
        os.setState(os.getOpen());
    }

    @Override
    public void printInvoiced() {
        os.setState(os.getInvoiced());
    }
}
