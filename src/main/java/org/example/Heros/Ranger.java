package org.example.Heros;

import org.example.InvalidArmorException;
import org.example.InvalidWeaponException;
import org.example.Item.*;
import org.example.Slot;

import java.util.Arrays;

public class Ranger extends Hero {

    private static Armor.ArmorType [] ValidArmor = {Armor.ArmorType.LEATHER, Armor.ArmorType.MAIL};
    private static Weapon.WeaponType[] ValidWeapon = {Weapon.WeaponType.BOWS};

    private HeroAttribute GainOnLevelUp = new HeroAttribute(1,5,1);

    public Ranger(String name){
        super(name);
        this.levelAttributes  = new HeroAttribute(1,7,1);
        this.CalculateTotalAttributes();
    }


    public void LevelUp(){
        levelAttributes = levelAttributes.combine(GainOnLevelUp);
        currentLevel ++;
        this.CalculateTotalAttributes();
    }

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

    public void EquipWeapon(Item weapon){
        try {
            if (!Arrays.asList(ValidWeapon).contains(weapon.getWeaponType())) {
                System.out.println("Invalid");
                throw new InvalidWeaponException();
            }
            if (weapon.getRequiredLevel() > currentLevel){
                System.out.println("LEVEL");
                throw new InvalidWeaponException();
            }

            equipment.put(weapon.getSlot(), weapon);
        }
        catch(InvalidWeaponException e){
            e.printStackTrace();
        }
    }

    public double getDamage(){
        double damage;

        if(equipment.get(Slot.WEAPON) == null){
            damage = 1+ ((double)totalAttributes.getDexterity()/100);
        }else{
            damage = equipment.get(Slot.WEAPON).getWeaponDamage() * (1+ ((double)totalAttributes.getDexterity()/100));
        }

        return damage;
    }

    public String Display(){
        
        this.CalculateTotalAttributes();
        
        String out = "";
        out += "Name: " + name + "\n";
        out += "Class: Ranger\n";
        out += "Level: " + currentLevel + "\n";
        out += "Strength: " + totalAttributes.getStrenght() + "\n";
        out += "Dexterity: " + totalAttributes.getDexterity() + "\n";
        out += "Intelligence: " + totalAttributes.getIntelligence() + "\n";
        out += "Damage: " + getDamage() + "\n";

        return out;
    }




}
