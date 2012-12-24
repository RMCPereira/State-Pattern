/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statepatternexample.ConcreteState;

import statepatternexample.State.EmotionalState;

/**
 *
 * @author TookieTookie
 */
public class HappyState implements EmotionalState {

    @Override
    public String sayHello() {
        return "Bye, friend!";
    }

    @Override
    public String sayGoodbye() {
        return "Hello, friend!";
    }
}
