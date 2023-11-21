package game.skills;

import game.monsters.Monster;
import game.characters.Character;

public class ChaosBolt extends Skills{

    public ChaosBolt() {
        super(15,25);
    }

    @Override
    public void attack(Monster target, Character user) {
        int dmg = (int) (this.getValue()*(0.1*user.getIntellect()));
        target.setHealth(target.getHealth() - dmg);
        user.setMana(user.getMana() - getCost());
        System.out.println(user.getName() + " used skill Chaos Bolt and hit the target for " + dmg + " damage!");
    }
}
