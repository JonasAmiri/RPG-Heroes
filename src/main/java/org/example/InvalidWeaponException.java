package org.example;

public class InvalidWeaponException extends Exception{

    public InvalidWeaponException(){
        super(" This weapon is either a non-valid type or the player has too low of a level");
    }
}
// This weapon is either a non-valid type or the player has too low of a level