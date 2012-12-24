/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern;

/**
 *
 * @author TookieTookie
 */
public class StatePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Order os = new Order();
        System.out.println(os);

        Service service1 = new Service("Install Linux", 0.00);
        Service service2 = new Service("Format Computer", 49.90);

        os.insertService(service1);
        os.insertService(service2);

        System.out.println(os);

        os.printInvoice();
        System.out.println();

        System.out.println(os);

        os.removeService(service2);
        System.out.println(os);

        os.requestPayment();
        System.out.println(os);

        os.printInvoice();
        System.out.println(os);
    }
}
