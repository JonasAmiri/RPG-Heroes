package org.example.Item;

import org.example.Heros.*;
import org.example.*;

public class Armor extends Item {

    private HeroAttribute ArmorAttribute;


    public enum ArmorType {
        CLOTH, LEATHER, MAIL, PLATE
    }

    public ArmorType getArmorType(){
        return armorType;
    }

    public Armor(ArmorType armorType, int requiredLevel, HeroAttribute ArmorAttribute, Slot slot) {
            this.armorType = armorType;
            this.slot = slot;
            this.requiredLevel = requiredLevel;
            this.ArmorAttribute = ArmorAttribute;
        }

    @Override
    public HeroAttribute getArmorAttribute(){
        return ArmorAttribute;
    }


}
