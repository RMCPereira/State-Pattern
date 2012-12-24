/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern.Solution;

/**
 *
 * @author TookieTookie
 */
public abstract class State {

    protected Order os;

    public State(Order os) {
        this.os = os;
    }

    public Order getOs() {
        return os;
    }

    public void insertService(Service service) {
        System.err.println("ERROR");
    }

    public void removeService(Service service) {
        System.err.println("ERROR");
    }

    public void cancelOS() {
        System.err.println("ERROR");
    }

    public void requestPayment() {
        System.err.println("ERROR");
    }

    public void printInvoiced() {
        System.err.println("ERROR");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
