/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevador.Normal;

/**
 * Define the states for a carousel door.
 * @author TookieTookie
 */
public interface DoorConstants {

    DoorState CLOSED = new DoorClosed();
    DoorState OPENING = new DoorOpening();
    DoorState OPEN = new DoorOpen();
    DoorState CLOSING = new DoorClosing();
    DoorState STAYOPEN = new DoorStayOpen();
}
