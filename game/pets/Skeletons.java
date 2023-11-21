package game.pets;

import game.monsters.Monster;
import game.characters.Character;

public class Skeletons extends Pets {
    public Skeletons() {
        super(25, 3, "Skeletons",100);
    }


    int health1 = 25;
    int mana1 = 100;
    int power1 = 3;

    @Override
    public void attack(Monster target) {
        System.out.println("3 Skeletons attacked " + target.getName() + " for " + getPower() + " damage!");
        int atp = this.getPower();
        target.setHealth(target.getHealth() - 3*atp);
    }

    @Override
    public void setPetStats(Character ch) {
        setHealth(getHealth() + ch.getStamina());
        setPower((int) (getPower()*(0.08*ch.getIntellect())));
        setMana(getMana() + ch.getIntellect());
    }

    @Override
    public void resetPetStats() {
        setHealth(health1);
        setPower(power1);
        setMana(mana1);
    }
}
