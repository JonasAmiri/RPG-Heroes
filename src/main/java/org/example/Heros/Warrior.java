package org.example.Heros;

import org.example.InvalidArmorException;
import org.example.InvalidWeaponException;
import org.example.Item.*;
import org.example.Slot;

import java.util.Arrays;

public class Warrior extends Hero {
    private static Armor.ArmorType [] ValidArmor = {Armor.ArmorType.MAIL, Armor.ArmorType.PLATE};
    private static Weapon.WeaponType[] ValidWeapon = {Weapon.WeaponType.AXES,Weapon.WeaponType.HAMMERS, Weapon.WeaponType.SWORDS};
    private HeroAttribute GainOnLevelUp = new HeroAttribute(3,2,1);

    public Warrior(String name){
        super(name);
        this.levelAttributes = new HeroAttribute(5,2,1);
        this.CalculateTotalAttributes();
    }
    @Override
    public HeroAttribute currentTotalAttributes(){
        return totalAttributes;
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

    public double getDamage(){
        double damage;

        if(equipment.get(Slot.WEAPON) == null){
            damage = 1 + ((double)totalAttributes.getStrenght()/100);
        }else{
            damage = equipment.get(Slot.WEAPON).getWeaponDamage() * (1+ ((double)totalAttributes.getStrenght()/100));
        }

        return damage;
    }

    public String Display(){

        String out = "";
        out += "Name: " + name + "\n";
        out += "Class: Warrior\n";
        out += "Level: " + currentLevel + "\n";
        out += "Strength: " + totalAttributes.getStrenght() + "\n";
        out += "Dexterity: " + totalAttributes.getDexterity() + "\n";
        out += "Intelligence: " + totalAttributes.getIntelligence() + "\n";
        out += "Damage: " + getDamage() + "\n";

        return out;
    }



}
