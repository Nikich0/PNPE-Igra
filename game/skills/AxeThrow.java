package game.skills;

import game.monsters.Monster;
import game.characters.Character;

public class AxeThrow extends Skills {

    public AxeThrow() {
        super(10, 20);
    }

    @Override
    public void attack(Monster target, Character user) {
        int dmg = (int) (this.getValue()*(0.25*user.getAgility()));
        target.setHealth(target.getHealth() - dmg);
        user.setMana(user.getMana() - getCost());
        System.out.println(user.getName() + " used skill Axe Throw and hit the target for " + dmg + " damage!");
    }
}
