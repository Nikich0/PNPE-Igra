package game.pets;

import game.monsters.Monster;
import game.characters.Character;


public class SaberTooth extends Pets {
    public SaberTooth() {
        super(50, 7, "Saber Tooth", 100);
    }

    int health1 = 50;
    int mana1 = 100;
    int power1 = 7;

    @Override
    public void attack(Monster target) {
        System.out.println("SaberTooth attacked " + target.getName() + " for " + getPower() + " damage!");
        int atp = this.getPower();
        target.setHealth(target.getHealth() - atp);
    }

    @Override
    public void setPetStats(Character ch) {
        setHealth(getHealth() + ch.getStamina());
        setPower((int) (getPower()*(0.1*ch.getAgility())));
        setMana(getMana() + ch.getIntellect());
    }

    @Override
    public void resetPetStats() {
        setHealth(health1);
        setPower(power1);
        setMana(mana1);
    }
}
