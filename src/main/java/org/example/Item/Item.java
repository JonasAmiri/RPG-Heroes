package org.example.Item;

import org.example.*;
import org.example.Heros.HeroAttribute;

public abstract class Item {
    protected String name;
    protected int requiredLevel;
    protected Slot slot;
    protected Armor.ArmorType armorType;
    protected Weapon.WeaponType weaponType;

    public Armor.ArmorType getArmorType(){
        return armorType;
    }
    public Weapon.WeaponType getWeaponType(){
        return weaponType;
    }


    public int getRequiredLevel(){
        return requiredLevel;
    }

    public String getName() {
        return name;
    }

    public Slot getSlot() {
        return slot;
    }

    public HeroAttribute getArmorAttribute(){
        return null;
    }

    public int getWeaponDamage(){
        return 0;
    }



}
