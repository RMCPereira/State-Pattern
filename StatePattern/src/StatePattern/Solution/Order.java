/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TookieTookie
 */
public class Order {

    private static Integer ID_GENERATION = 1;
    private State open, closed, canceled, invoiced;
    private Integer id;
    private State state;
    private List<Service> services;

    //Event 1
    public Order() {
        id = ID_GENERATION++;

        open = new Open(this);
        closed = new Closed(this);
        canceled = new Canceled(this);
        invoiced = new Invoiced(this);

        state = open;
        services = new ArrayList<Service>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getOpen() {
        return open;
    }

    public State getInvoiced() {
        return invoiced;
    }

    //Event 2
    public void insertService(Service service) {
        state.insertService(service);
    }

    //Event 3
    public void removeService(Service service) {
        state.removeService(service);
    }

    //Event 5
    public void requestPayment() {
        state.requestPayment();
    }

    //Event 6
    public void printInvoice() {
        state.printInvoiced();
    }

    @Override
    public String toString() {
        return "************************************ OS id: " + id + "************************************\nState: " + state + "\nServices:" + services + "\n\n\n";
    }
}
