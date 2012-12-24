/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern;

import com.sun.org.glassfish.external.arc.Stability;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TookieTookie
 */
public class Order {

    private static Integer ID_GENERATION = 1;

    enum State {

        OPEN, CLOSE, CANCELED, INVOICED //NOVO STATE?!?!
    }
    private Integer id;
    private State state;
    private List<Service> services;

    //Event 1
    public Order() {
        id = ID_GENERATION++;
        state = State.OPEN;
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

    //Event 2
    public void insertService(Service service) {
        switch (state) {
            case OPEN:
                services.add(service);
                break;
            case CLOSE:
                state = State.OPEN;
                services.add(service);
                break;
            case CANCELED:
            case INVOICED:
                System.out.println("Impossible");
                break;

        }
    }
    //Event 3

    public void removeService(Service service) {
        switch (state) {
            case OPEN:
                services.remove(service);
                break;
            case CLOSE:
                state = State.OPEN;
                services.remove(service);
                break;
            case CANCELED:
            case INVOICED:
                System.out.println("Impossible");
                break;

        }
    }
    //Event 4

    public void cancelOS() {
        switch (state) {
            case OPEN:
                state = State.CANCELED;
                break;
            case CLOSE:
                System.out.println("Frist reopen the order");
                break;
            case CANCELED:
                System.out.println("Already canceled");
                break;
            case INVOICED:
                System.out.println("Impossible");
                break;

        }
    }
    //Event 5

    public void requestPayment() {
        switch (state) {
            case OPEN:
                state = State.CLOSE;
                break;
            case CLOSE:
                System.out.println("Already closed");
                break;
            case CANCELED:
            case INVOICED:
                System.out.println("Impossible");
                break;

        }
    }
    //Event 6

    public void printInvoice() {
        switch (state) {
            case OPEN:
                System.out.println("First request for payment");
                break;
            case CLOSE:
                state = State.INVOICED;
                break;
            case CANCELED:
            case INVOICED:
                System.out.println("Impossible");
                break;

        }
    }

    @Override
    public String toString() {
        return "************************************ OS id: " + id + "************************************\nState: " + state + "\nServices:" + services + "\n\n\n";
    }
}
