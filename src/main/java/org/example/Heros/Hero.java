package org.example.Heros;

import org.example.Item.*;
import org.example.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public abstract class Hero {
    protected String name;
    protected int levelStart;
    protected int currentLevel;
    protected HeroAttribute levelAttributes;
    protected HeroAttribute totalAttributes;
    protected HeroAttribute GainOnLevelUp;
    protected String Class;

    protected Weapon.WeaponType ValidWeapon[];
    protected Armor.ArmorType ValidArmor[];

    protected Map<Slot, Item> equipment = new HashMap<Slot, Item>();

    List<Weapon> WeaponList = new ArrayList<>();
    List<Armor> ArmorList = new ArrayList<>();



    public Hero(String name) {
        this.name = name;
        this.levelStart = 1;
        currentLevel = 1;

        this.equipment.put(Slot.HEAD, null);
        this.equipment.put(Slot.BODY, null);
        this.equipment.put(Slot.LEGS, null);
        this.equipment.put(Slot.WEAPON, null);

        
    }

    public Hero() {

    }

    public Weapon.WeaponType[] getValidWeapon() {
        return ValidWeapon;
    }

    public Armor.ArmorType[] getValidArmor() {
        return ValidArmor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelStart() {
        return levelStart;
    }

    public int  getCurrentLevel() {
            return currentLevel;
        }

    public void setLevelStart(int levelStart) {
        this.levelStart = levelStart;
    }

    public abstract void LevelUp();
    public void Equip(Weapon newWeapon){
        WeaponList.add(newWeapon);

    }
    public void Equip(Armor newArmor){
        ArmorList.add(newArmor);
    }

    public abstract String Display ();

    public abstract void EquipArmor(Item armor);

    public abstract void EquipWeapon(Item weapon);


    // Calculate the total Attributes for the character
    // Add up all the Armor attributes and combine them with the level Attributes
    protected void CalculateTotalAttributes(){
        HeroAttribute totalArmorGain = new HeroAttribute(0,0,0);

        if(totalAttributes != null){
            totalAttributes.reset();
        }

        if (equipment.get(Slot.HEAD) != null){
            totalArmorGain = totalArmorGain.combine(equipment.get(Slot.HEAD).getArmorAttribute());
        }
        if (equipment.get(Slot.BODY) != null){
            totalArmorGain = totalArmorGain.combine(equipment.get(Slot.BODY).getArmorAttribute());
        }
        if (equipment.get(Slot.LEGS) != null){
            totalArmorGain = totalArmorGain.combine(equipment.get(Slot.LEGS).getArmorAttribute());
        }
        
        totalAttributes = totalArmorGain.combine(levelAttributes);

    }

    public HeroAttribute currentTotalAttributes(){
        return null;
    }

    // Get the Item at the specified Slot (HEAD, BODY, LEGS or WEAPON)
    public Item getItem(Slot s){
        return equipment.get(s);
    }

    public abstract double getDamage();


}
