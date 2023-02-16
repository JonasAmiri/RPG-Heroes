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

class RogueTest {

    Hero dummyRogue;

    @BeforeEach
    void setUp(){

        dummyRogue = new Rogue("dummyRogue");

    }

    @Test
    void levelUp() {

        dummyRogue.LevelUp();
        dummyRogue.LevelUp();
        dummyRogue.LevelUp();
        dummyRogue.LevelUp();

        Assertions.assertEquals(4,4);
    }

    @Test
    void equipArmor_EquippingArmor_HeroShouldEquipArmorInSlot() {

        Item Helmet = new Armor(LEATHER, 1, new HeroAttribute(3,1,10),HEAD);
        dummyRogue.EquipArmor(Helmet);
        assertEquals(Helmet, dummyRogue.getItem(HEAD));


        Item chestPlate = new Armor(LEATHER, 1, new HeroAttribute(3,1,10),BODY);
        dummyRogue.EquipArmor(chestPlate);
        assertEquals(chestPlate, dummyRogue.getItem(BODY));


        Item Legs = new Armor(LEATHER, 1, new HeroAttribute(3,1,10),LEGS);
        dummyRogue.EquipArmor(Legs);
        assertEquals(Legs, dummyRogue.getItem(LEGS));


        Item HelmetMail = new Armor(MAIL, 1, new HeroAttribute(3,1,10),HEAD);
        dummyRogue.EquipArmor(HelmetMail);
        assertEquals(HelmetMail, dummyRogue.getItem(HEAD));


        Item ChestPLateMAil = new Armor(MAIL, 1, new HeroAttribute(3,1,10),BODY);
        dummyRogue.EquipArmor(ChestPLateMAil);
        assertEquals(ChestPLateMAil, dummyRogue.getItem(BODY));


        Item legs = new Armor(MAIL, 1, new HeroAttribute(3,1,10),LEGS);
        dummyRogue.EquipArmor(legs);
        assertEquals(legs, dummyRogue.getItem(LEGS));


        Item Cloth = new Armor(CLOTH, 1, new HeroAttribute(3,1,10),BODY);
        dummyRogue.EquipArmor(Cloth);
        assertNotEquals(CLOTH, dummyRogue.getItem(BODY));


        Item Plate = new Armor(PLATE, 1, new HeroAttribute(3,1,10),BODY);
        dummyRogue.EquipArmor(Plate);
        assertNotEquals(PLATE, dummyRogue.getItem(BODY));

    }

    @Test
    void equipWeapon() {

        Item Axe = new Weapon(1, Weapon.WeaponType.AXES, 1);
        dummyRogue.EquipWeapon(Axe);
        Assertions.assertNotEquals(Axe, dummyRogue.getItem(Slot.WEAPON));


        Item Bows = new Weapon(1, Weapon.WeaponType.BOWS, 1);
        dummyRogue.EquipWeapon(Bows);
        Assertions.assertNotEquals(Bows, dummyRogue.getItem(Slot.WEAPON));


        Item Dagger = new Weapon(1, Weapon.WeaponType.DAGGERS, 1);
        dummyRogue.EquipWeapon(Dagger);
        Assertions.assertEquals(Dagger, dummyRogue.getItem(Slot.WEAPON));


        Item Hammer = new Weapon(1, Weapon.WeaponType.HAMMERS, 1);
        dummyRogue.EquipWeapon(Hammer);
        Assertions.assertNotEquals(Hammer, dummyRogue.getItem(Slot.WEAPON));


        Item Staff = new Weapon(1, Weapon.WeaponType.STAFFS, 1);
        dummyRogue.EquipWeapon(Staff);
        Assertions.assertNotEquals(Staff, dummyRogue.getItem(Slot.WEAPON));


        Item Sword = new Weapon(1, Weapon.WeaponType.SWORDS, 1);
        dummyRogue.EquipWeapon(Sword);
        Assertions.assertEquals(Sword, dummyRogue.getItem(Slot.WEAPON));


        Item Wand = new Weapon(1, Weapon.WeaponType.WANDS, 1);
        dummyRogue.EquipWeapon(Wand);
        Assertions.assertNotEquals(Wand, dummyRogue.getItem(Slot.WEAPON));
    }

    @Test
    void getDamage() {

        double damage = 1+ (double)6/100;
        Assertions.assertEquals(damage, dummyRogue.getDamage(), 0.000001d);
    }

    @Test
    void display() {

        String out = "";
        out += "Name: dummyRogue\n";
        out += "Class: Rogue\n";
        out += "Level: 1\n";
        out += "Strength: 1\n";
        out += "Dexterity: 7\n";
        out += "Intelligence: 1\n";
        out += "Damage: 1.08\n";
    }
}