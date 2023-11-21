package game.characters;

import game.items.Item;
import game.monsters.Monster;

public abstract class Character {
    private String name;
    private int health;
    private int power;
    private int mana;
    private String race;
    private int stamina;
    private int agility;
    private int intellect;

    public Character(String name, int health, int power, int mana, String race, int stamina, int agility, int intellect) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.mana = mana;
        this.race = race;
        this.stamina = stamina;
        this.agility = agility;
        this.intellect = intellect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public abstract void attack(Monster target);
    public abstract void defend(int atp);
    public abstract void setStats();
    public abstract void resetStats();
    public abstract void pickItem(Item item);

    public boolean isAlive()
    {
        return this.health > 0;
    }
    public boolean enoughMana()
    {
        return this.mana > 0;
    }

    public void introduce()
    {
        System.out.println("My name is " + getName() + "! I have " + getHealth() + " health, " + getPower() + " power and " + getMana() + " mana! My race is " + getRace() + "!");
    }

}
