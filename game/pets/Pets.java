package game.pets;

import game.monsters.Monster;
import game.characters.Character;

public abstract class Pets {
    private int health;
    private int power;
    private String type;
    private int mana;

    public Pets(int health, int power, String type, int mana) {
        this.health = health;
        this.power = power;
        this.type = type;
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public boolean enoughMana()
    {
        return this.mana > 0;
    }

    public abstract void attack(Monster target);
    public abstract void setPetStats(Character ch);

    public abstract void resetPetStats();

}
