package org.example.Heros;

public class HeroAttribute {
    private int Strength;
    private int Dexterity;
    private int Intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        Strength = strength;
        Dexterity = dexterity;
        Intelligence = intelligence;
    }

    //Reset all the Parameters to 0
    public void reset(){
        Strength = 0;
        Dexterity = 0;
        Intelligence = 0;
    }

    public int getStrenght() {
        return Strength;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public int getIntelligence() {
        //CalculateTotalAttributes();

        return Intelligence;
    }

    // Combine two HeroAttributes by adding up their parameters
    // Returns the combined HeroAttribute
    public HeroAttribute combine(HeroAttribute heroAttribute){

        Strength = Strength + heroAttribute.Strength;
        Dexterity = Dexterity + heroAttribute.Dexterity;
        Intelligence = Intelligence + heroAttribute.Intelligence;

        return this;
    }

}
