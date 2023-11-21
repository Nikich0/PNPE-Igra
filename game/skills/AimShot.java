package game.skills;

import game.monsters.Monster;
import game.characters.Character;

public class AimShot extends Skills{

    public AimShot() {
        super(7, 10);
    }

    @Override
    public void attack(Monster target, Character user) {
        int dmg = (int) (this.getValue()*(0.3*user.getAgility()));
        target.setHealth(target.getHealth() - dmg);
        user.setMana(user.getMana() - getCost());
        System.out.println(user.getName() + " used skill Aim Shot and hit the target for " + dmg + " damage!");
    }
}
