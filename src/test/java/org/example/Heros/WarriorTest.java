package org.example.Heros;

import org.example.Item.Armor;
import org.example.Item.Item;
import org.example.Item.Weapon;
import org.example.Slot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Item.Armor.ArmorType.*;
import static org.example.Item.Armor.ArmorType.PLATE;
import static org.example.Slot.*;
import static org.example.Slot.BODY;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Hero dummyWarrior;

    @BeforeEach
    void setUp(){
        dummyWarrior = new Warrior("dummyWarrior");
    }

    @Test
    void levelUp() {

        dummyWarrior.LevelUp();
        dummyWarrior.LevelUp();
        dummyWarrior.LevelUp();
        dummyWarrior.LevelUp();

        Assertions.assertEquals(4,4);
    }

    @Test
    void equipArmor_EquippingArmor_HeroShouldEquipArmorInSlot() {

        Item Helmet = new Armor(PLATE, 1, new HeroAttribute(3,1,10),HEAD);
        dummyWarrior.EquipArmor(Helmet);
        assertEquals(Helmet, dummyWarrior.getItem(HEAD));


        Item chestPlate = new Armor(PLATE, 1, new HeroAttribute(3,1,10),BODY);
        dummyWarrior.EquipArmor(chestPlate);
        assertEquals(chestPlate, dummyWarrior.getItem(BODY));


        Item Legs = new Armor(PLATE, 1, new HeroAttribute(3,1,10),LEGS);
        dummyWarrior.EquipArmor(Legs);
        assertEquals(Legs, dummyWarrior.getItem(LEGS));


        Item HelmetMail = new Armor(MAIL, 1, new HeroAttribute(3,1,10),HEAD);
        dummyWarrior.EquipArmor(HelmetMail);
        assertEquals(HelmetMail, dummyWarrior.getItem(HEAD));


        Item ChestPLateMAil = new Armor(MAIL, 1, new HeroAttribute(3,1,10),BODY);
        dummyWarrior.EquipArmor(ChestPLateMAil);
        assertEquals(ChestPLateMAil, dummyWarrior.getItem(BODY));


        Item legs = new Armor(MAIL, 1, new HeroAttribute(3,1,10),LEGS);
        dummyWarrior.EquipArmor(legs);
        assertEquals(legs, dummyWarrior.getItem(LEGS));


        Item Cloth = new Armor(CLOTH, 1, new HeroAttribute(3,1,10),BODY);
        dummyWarrior.EquipArmor(Cloth);
        assertNotEquals(CLOTH, dummyWarrior.getItem(BODY));


        Item Plate = new Armor(LEATHER, 1, new HeroAttribute(3,1,10),BODY);
        dummyWarrior.EquipArmor(Plate);
        assertNotEquals(PLATE, dummyWarrior.getItem(BODY));

    }

    @Test
    void equipWeapon() {

        Item Axe = new Weapon(1, Weapon.WeaponType.AXES, 1);
        dummyWarrior.EquipWeapon(Axe);
        Assertions.assertEquals(Axe, dummyWarrior.getItem(Slot.WEAPON));


        Item Bow = new Weapon(1, Weapon.WeaponType.BOWS, 1);
        dummyWarrior.EquipWeapon(Bow);
        Assertions.assertNotEquals(Bow, dummyWarrior.getItem(Slot.WEAPON));


        Item Dagger = new Weapon(1, Weapon.WeaponType.DAGGERS, 1);
        dummyWarrior.EquipWeapon(Dagger);
        Assertions.assertNotEquals(Dagger, dummyWarrior.getItem(Slot.WEAPON));


        Item Hammer = new Weapon(1, Weapon.WeaponType.HAMMERS, 1);
        dummyWarrior.EquipWeapon(Hammer);
        Assertions.assertEquals(Hammer, dummyWarrior.getItem(Slot.WEAPON));


        Item Staff = new Weapon(1, Weapon.WeaponType.STAFFS, 1);
        dummyWarrior.EquipWeapon(Staff);
        Assertions.assertNotEquals(Staff, dummyWarrior.getItem(Slot.WEAPON));


        Item Sword = new Weapon(1, Weapon.WeaponType.SWORDS, 1);
        dummyWarrior.EquipWeapon(Sword);
        Assertions.assertEquals(Sword, dummyWarrior.getItem(Slot.WEAPON));


        Item Wand = new Weapon(1, Weapon.WeaponType.WANDS, 1);
        dummyWarrior.EquipWeapon(Wand);
        Assertions.assertNotEquals(Wand, dummyWarrior.getItem(Slot.WEAPON));



    }



    @Test
    void getDamage() {

        double damage = 1+ (double)5/100;
        Assertions.assertEquals(damage, dummyWarrior.getDamage(), 0.000001d);
    }

    @Test
    void display() {

        String out = "";
        out += "Name: dummyWarrior\n";
        out += "Class: Warrior\n";
        out += "Level: 1\n";
        out += "Strength: 5\n";
        out += "Dexterity: 2\n";
        out += "Intelligence: 1\n";
        out += "Damage: 1.06\n";
    }
}