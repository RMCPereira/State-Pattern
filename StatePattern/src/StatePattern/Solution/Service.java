/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern.Solution;

/**
 *
 * @author TookieTookie
 */
public class Service {

    private String name;
    private double price;

    public Service() {
        this(null, 0);
    }

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + price + "€";
    }
}
