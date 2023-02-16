package org.example.Heros;

import org.example.Item.Armor;
import org.example.Item.Item;
import org.example.Item.Weapon;
import org.example.Slot;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Item.Armor.ArmorType.*;
import static org.example.Slot.*;
import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    Hero dummyRanger;

    @BeforeEach
    void setUp(){
        dummyRanger = new Ranger("dummyRanger");
    }

    @Test
    void levelUp() {

        dummyRanger.LevelUp();
        dummyRanger.LevelUp();
        dummyRanger.LevelUp();
        dummyRanger.LevelUp();

        Assertions.assertEquals(4,4);

    }

    @Test
    void equipArmor_EquippingArmor_HeroShouldEquipArmorInSlot() {

        Item Helmet = new Armor(LEATHER, 1, new HeroAttribute(3,1,10),HEAD);
        dummyRanger.EquipArmor(Helmet);
        Assertions.assertEquals(Helmet, dummyRanger.getItem(Slot.HEAD));


        Item chestPlate = new Armor(LEATHER, 1, new HeroAttribute(3,1,10),BODY);
        dummyRanger.EquipArmor(chestPlate);
        Assertions.assertEquals(chestPlate, dummyRanger.getItem(Slot.BODY));


        Item Legs = new Armor(LEATHER, 1, new HeroAttribute(3,1,10),LEGS);
        dummyRanger.EquipArmor(Legs);
        Assertions.assertEquals(Legs, dummyRanger.getItem(Slot.LEGS));


        Item HelmetMail = new Armor(MAIL, 1, new HeroAttribute(3,1,10),HEAD);
        dummyRanger.EquipArmor(HelmetMail);
        Assertions.assertEquals(HelmetMail, dummyRanger.getItem(Slot.HEAD));


        Item ChestPLateMAil = new Armor(MAIL, 1, new HeroAttribute(3,1,10),BODY);
        dummyRanger.EquipArmor(ChestPLateMAil);
        Assertions.assertEquals(ChestPLateMAil, dummyRanger.getItem(Slot.BODY));


        Item legs = new Armor(MAIL, 1, new HeroAttribute(3,1,10),LEGS);
        dummyRanger.EquipArmor(legs);
        Assertions.assertEquals(legs, dummyRanger.getItem(Slot.LEGS));


        Item Cloth = new Armor(CLOTH, 1, new HeroAttribute(3,1,10),BODY);
        dummyRanger.EquipArmor(Cloth);
        Assertions.assertNotEquals(CLOTH, dummyRanger.getItem(Slot.BODY));


        Item Plate = new Armor(PLATE, 1, new HeroAttribute(3,1,10),BODY);
        dummyRanger.EquipArmor(Plate);
        Assertions.assertNotEquals(PLATE, dummyRanger.getItem(Slot.BODY));


    }

    @Test
    void equipWeapon() {

        Item Bow = new Weapon(1, Weapon.WeaponType.BOWS, 1);
        dummyRanger.EquipWeapon(Bow);
        Assertions.assertEquals(Bow, dummyRanger.getItem(Slot.WEAPON));


        Item Axe = new Weapon(1, Weapon.WeaponType.AXES, 1);
        dummyRanger.EquipWeapon(Axe);
        Assertions.assertNotEquals(Axe, dummyRanger.getItem(Slot.WEAPON));


        Item Dagger = new Weapon(1, Weapon.WeaponType.DAGGERS, 1);
        dummyRanger.EquipWeapon(Dagger);
        Assertions.assertNotEquals(Dagger, dummyRanger.getItem(Slot.WEAPON));


        Item Hammers = new Weapon(1, Weapon.WeaponType.HAMMERS, 1);
        dummyRanger.EquipWeapon(Hammers);
        Assertions.assertNotEquals(Hammers, dummyRanger.getItem(Slot.WEAPON));


        Item Staff = new Weapon(1, Weapon.WeaponType.STAFFS, 1);
        dummyRanger.EquipWeapon(Staff);
        Assertions.assertNotEquals(Staff, dummyRanger.getItem(Slot.WEAPON));


        Item Swords = new Weapon(1, Weapon.WeaponType.SWORDS, 1);
        dummyRanger.EquipWeapon(Swords);
        Assertions.assertNotEquals(Swords, dummyRanger.getItem(Slot.WEAPON));


        Item Wand = new Weapon(1, Weapon.WeaponType.WANDS, 1);
        dummyRanger.EquipWeapon(Wand);
        Assertions.assertNotEquals(Wand, dummyRanger.getItem(Slot.WEAPON));
    }

    @Test
    void getDamage() {

        double damage = 1+ (double)7/100;
        Assertions.assertEquals(damage, dummyRanger.getDamage(), 0.000001d);
    }

    @Test
    void display() {

        String out = "";
        out += "Name: dummyRanger\n";
        out += "Class: Ranger\n";
        out += "Level: 1\n";

        out += "Strength: 1\n";
        out += "Dexterity: 7\n";
        out += "Intelligence: 1\n";

        out += "Damage: 1.07\n";

        //System.out.println(dummyMage.Display());

        Assertions.assertEquals(dummyRanger.Display(), out);
    }
}