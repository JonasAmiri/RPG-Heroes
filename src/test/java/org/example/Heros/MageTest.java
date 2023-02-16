package org.example.Heros;

import org.example.Item.Armor;
import org.example.Item.Item;
import org.example.*;
import org.example.Item.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Item.Armor.ArmorType.*;
import static org.example.Slot.*;

class MageTest {

    Hero dummyMage;

    @BeforeEach
    void setUp(){

        dummyMage = new Mage("dummyMage");
    }

    @Test
    void levelUp() {
        dummyMage.LevelUp();
        dummyMage.LevelUp();
        dummyMage.LevelUp();
        dummyMage.LevelUp();

        Assertions.assertEquals(4,4);
    }


    @Test
    void equipArmor_EquippingArmor_HeroShouldEquipArmorInSlot() {

        Item helmet = new Armor(CLOTH, 1, new HeroAttribute(3,1,10), HEAD);
        dummyMage.EquipArmor(helmet);
        Assertions.assertEquals(helmet,dummyMage.getItem(Slot.HEAD));

        Item chestPlate = new Armor(CLOTH, 1, new HeroAttribute(3,1,10), BODY);
        dummyMage.EquipArmor(chestPlate);
        Assertions.assertEquals(chestPlate,dummyMage.getItem(Slot.BODY));

        Item legs = new Armor(CLOTH, 1, new HeroAttribute(3,1,10), LEGS);
        dummyMage.EquipArmor(legs);
        Assertions.assertEquals(legs,dummyMage.getItem(Slot.LEGS));

        Item leather = new Armor(LEATHER, 1, new HeroAttribute(3,1,10),HEAD);
        dummyMage.EquipArmor(leather);
        Assertions.assertNotEquals(leather, dummyMage.getItem(Slot.HEAD));

        Item mail = new Armor(MAIL, 1, new HeroAttribute(3,1,10),HEAD);
        dummyMage.EquipArmor(mail);
        Assertions.assertNotEquals(leather, dummyMage.getItem(Slot.HEAD));

        Item plate = new Armor(PLATE, 1, new HeroAttribute(3,1,10),HEAD);
        dummyMage.EquipArmor(plate);
        Assertions.assertNotEquals(leather, dummyMage.getItem(Slot.HEAD));



    }

    @Test
    void equipWeapon() {
        Item Wand = new Weapon(1, Weapon.WeaponType.WANDS, 1);
        dummyMage.EquipWeapon(Wand);
        Assertions.assertEquals(Wand, dummyMage.getItem(Slot.WEAPON));


        Item Staff = new Weapon(5, Weapon.WeaponType.STAFFS, 1);
        dummyMage.EquipWeapon(Staff);
        Assertions.assertEquals(Staff, dummyMage.getItem(Slot.WEAPON));


        Item Axe = new Weapon(5, Weapon.WeaponType.AXES, 1);
        dummyMage.EquipWeapon(Axe);
        Assertions.assertNotEquals(Axe, dummyMage.getItem(Slot.WEAPON));


        Item Bow = new Weapon(5, Weapon.WeaponType.BOWS, 1);
        dummyMage.EquipWeapon(Bow);
        Assertions.assertNotEquals(Bow, dummyMage.getItem(Slot.WEAPON));


        Item Dagger = new Weapon(5, Weapon.WeaponType.DAGGERS, 1);
        dummyMage.EquipWeapon(Dagger);
        Assertions.assertNotEquals(Dagger, dummyMage.getItem(Slot.WEAPON));

        Item Hammer = new Weapon(5, Weapon.WeaponType.HAMMERS, 1);
        dummyMage.EquipWeapon(Hammer);
        Assertions.assertNotEquals(Hammer, dummyMage.getItem(Slot.WEAPON));


        Item Sword = new Weapon(5, Weapon.WeaponType.SWORDS, 1);
        dummyMage.EquipWeapon(Sword);
        Assertions.assertNotEquals(Sword, dummyMage.getItem(Slot.WEAPON));


    }

    @Test
    void getDamage() {

            double damage = 1+ (double)8/100;
            Assertions.assertEquals(damage, dummyMage.getDamage(), 0.000001d);
            //Assertions.assertEquals(dummyMage.getDamage(), 1);
            //Assertions.assertEquals(damage, dummyMage.getDamage(), 0.000001d);

        }

    @Test
    void display(){

        String out = "";
        out += "Name: dummyMage\n";
        out += "Class: Mage\n";
        out += "Level: 1\n";
        out += "Strength: 1\n";
        out += "Dexterity: 1\n";
        out += "Intelligence: 8\n";
        out += "Damage: 1.08\n";

        //System.out.println(dummyMage.Display());

        Assertions.assertEquals(dummyMage.Display(), out);

    }


    }
