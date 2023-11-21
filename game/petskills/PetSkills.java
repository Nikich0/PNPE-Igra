package game.petskills;

import game.pets.Pets;
import game.monsters.Monster;

public abstract class PetSkills {
    private int value;
    private int cost;

    public PetSkills(int value, int cost) {
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

    public abstract void attack(Monster target, Pets user);
}
