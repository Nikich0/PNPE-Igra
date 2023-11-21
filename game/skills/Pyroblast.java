package game.skills;

import game.monsters.Monster;
import game.characters.Character;

public class Pyroblast extends Skills{

    public Pyroblast() {
        super(20, 30);
    }

    @Override
    public void attack(Monster target, Character user) {
        int dmg = (int) (this.getValue()*(0.15*user.getIntellect()));
        target.setHealth(target.getHealth() - dmg);
        user.setMana(user.getMana() - getCost());
        System.out.println(user.getName() + " used skill Pyro Blast and hit the target for " + dmg + " damage!");
    }
}
