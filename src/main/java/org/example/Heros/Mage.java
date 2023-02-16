package org.example.Heros;
import java.util.Arrays;
import com.sun.tools.jconsole.JConsoleContext;
import org.example.Item.*;
import org.example.*;

public class Mage extends Hero {

    private static Armor.ArmorType [] ValidArmor = {Armor.ArmorType.CLOTH};
    private static Weapon.WeaponType[] ValidWeapon = {Weapon.WeaponType.STAFFS,Weapon.WeaponType.WANDS};

    private HeroAttribute GainOnLevelUp = new HeroAttribute(1,1,5);

    public Mage(String name){
        super(name);
        this.levelAttributes  = new HeroAttribute(1,1,8);
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

    // Equpt a piece of Armor
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

    // Equpt a new Weapon
    // Check if Weapon is of valid type and the player level is high enough
    // If Weapon slot is occupied, overwrite the slot
    public void EquipWeapon(Item weapon){
        try {
            if (!Arrays.asList(ValidWeapon).contains(weapon.getWeaponType())) {
                System.out.println("Invalid");
                throw new InvalidWeaponException();
            }
            if (weapon.getRequiredLevel() > currentLevel){
                System.out.println("Level");
                throw new InvalidWeaponException();
            }

            equipment.put(weapon.getSlot(), weapon);
        }
        catch(InvalidWeaponException e){
            e.printStackTrace();
        }
    }

    // Calculate the Damage with the following function:
    // WeaponDamage * (1/(Intelligence/100))
    // If no weapon: WeaponDamage is seen as 1
    public double getDamage(){

        double damage;

        if(equipment.get(Slot.WEAPON) == null){
            damage = 1+ ((double)totalAttributes.getIntelligence()/100);
        }else{
            damage = equipment.get(Slot.WEAPON).getWeaponDamage() * (1+ ((double)totalAttributes.getIntelligence()/100));
        }

        return damage;

    }

    // Returns a string containing the current Name, Class, Level, Attributes and Damage of the Hero
    public String Display(){

        //this.CalculateTotalAttributes();

        String out = "";
        out += "Name: " + name + "\n";
        out += "Class: Mage\n";
        out += "Level: " + currentLevel + "\n";
        out += "Strength: " + totalAttributes.getStrenght() + "\n";
        out += "Dexterity: " + totalAttributes.getDexterity() + "\n";
        out += "Intelligence: " + totalAttributes.getIntelligence() + "\n";
        out += "Damage: " + getDamage() + "\n";

        return out;
    }


}
