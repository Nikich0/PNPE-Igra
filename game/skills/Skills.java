package game.skills;

import game.monsters.Monster;
import game.characters.Character;

public abstract class Skills {
    private int value;
    private int cost;

    public Skills(int value, int cost) {
        this.value = value;
        this.cost = cost;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract void attack(Monster target, Character user);
}
