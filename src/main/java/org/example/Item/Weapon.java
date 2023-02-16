package org.example.Item;

public class Weapon extends Item{
    private int weaponDamage;

    public enum WeaponType{
        AXES, BOWS, DAGGERS, HAMMERS, STAFFS, SWORDS, WANDS
    }

    public Weapon(int weaponDamage, WeaponType weaponType, int requiredLevel) {
        this.weaponDamage = weaponDamage;
        this.weaponType = weaponType;
        this.slot = slot.WEAPON;
        this.requiredLevel = requiredLevel;
    }

    @Override
    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

}
