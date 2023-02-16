package org.example.Heros;

import org.example.InvalidArmorException;
import org.example.InvalidWeaponException;
import org.example.Item.*;
import org.example.Slot;

import java.util.Arrays;

public class Rogue extends Hero {
    private static Armor.ArmorType [] ValidArmor = {Armor.ArmorType.LEATHER, Armor.ArmorType.MAIL};
    private static Weapon.WeaponType[] ValidWeapon = {Weapon.WeaponType.DAGGERS,Weapon.WeaponType.SWORDS};
    private HeroAttribute GainOnLevelUp = new HeroAttribute(1,4,1);

    public Rogue(String name){
        super(name);
        this.levelAttributes = new HeroAttribute(2,6,1);
        this.CalculateTotalAttributes();

    }

    // Level up the character
    // Increase the current Level and add the levelGain to the levelAttributes
    // Calculate the new total Attributes

    public void LevelUp(){
        levelAttributes = levelAttributes.combine(GainOnLevelUp);
        currentLevel ++;
        this.CalculateTotalAttributes();
    }

    // Equip a piece of Armor
    // Check if Armor is of valid type and the player level is high enough
    // If specified slot is occupied, overwrite the slot
    public void EquipArmor(Item armor){
        try {
            if (!Arrays.asList(ValidArmor).contains(armor.getArmorType())) {
                throw new InvalidArmorException();
            }
            if (armor.getRequiredLevel() > currentLevel){
                throw new InvalidArmorException();
            }

            equipment.put(armor.getSlot(), armor);
        }
        catch(InvalidArmorException e){
            e.printStackTrace();
        }
        this.CalculateTotalAttributes();

    }

    // Equip a new Weapon
    // Check if Weapon is of valid type and the player level is high enough
    // If Weapon slot is occupied, overwrite the slot
    public void EquipWeapon(Item weapon){
        try {
            if (!Arrays.asList(ValidWeapon).contains(weapon.getWeaponType())) {
                throw new InvalidWeaponException();
            }
            if (weapon.getRequiredLevel() > currentLevel){
                throw new InvalidWeaponException();
            }

            equipment.put(weapon.getSlot(), weapon);
        }
        catch(InvalidWeaponException e){
            e.printStackTrace();
        }
    }

    // Calculate the Damage with the following function:
    // WeaponDamage * (1/(Dexterity/100))
    // If no weapon: WeaponDamage is seen as 1

    public double getDamage(){
        double damage;

        if(equipment.get(Slot.WEAPON) == null){
            damage = 1+ ((double)totalAttributes.getDexterity()/100);
        }else{
            damage = equipment.get(Slot.WEAPON).getWeaponDamage() * (1+ ((double)totalAttributes.getDexterity()/100));
        }

        return damage;
    }

    // Returns a string containing the current Name, Class, Level, Attributes and Damage of the Hero

    public String Display(){

        this.CalculateTotalAttributes();

        String out = "";
        out += "Name: " + name + "\n";
        out += "Class: Rogue\n";
        out += "Level: " + currentLevel + "\n";
        out += "Strength: " + totalAttributes.getStrenght() + "\n";
        out += "Dexterity: " + totalAttributes.getDexterity() + "\n";
        out += "Intelligence: " + totalAttributes.getIntelligence() + "\n";
        out += "Damage: " + getDamage() + "\n";

        return out;
    }



}
