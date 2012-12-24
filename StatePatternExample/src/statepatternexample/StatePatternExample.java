/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statepatternexample;

import statepatternexample.ConcreteState.HappyState;
import statepatternexample.ConcreteState.SadState;
import statepatternexample.Context.Person;

/**
 *
 * @author TookieTookie
 */
public class StatePatternExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person person = new Person(new HappyState());
        System.out.println("Hello in happy state: " + person.sayHello());
        System.out.println("Goodbye in happy state: " + person.sayGoodbye());

        person.setEmotionalState(new SadState());
        System.out.println("Hello in sad state: " + person.sayHello());
        System.out.println("Goodbye in sad state: " + person.sayGoodbye());
    }
}
