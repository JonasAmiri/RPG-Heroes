package org.example;

public class InvalidArmorException extends Exception{


    public InvalidArmorException(){
        super(" This weapon is either a non-valid type or the player has too low of a level");
    }
}
