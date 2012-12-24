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
public class SadState implements EmotionalState {

    @Override
    public String sayGoodbye() {
        return "Bye. Sniff, sniff.";
    }

    @Override
    public String sayHello() {
        return "Hello. Sniff, sniff.";
    }
}
