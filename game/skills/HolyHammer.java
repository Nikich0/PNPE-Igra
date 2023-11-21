package game.skills;

import game.monsters.Monster;
import game.characters.Character;

public class HolyHammer extends Skills{

    public HolyHammer() {
        super(10, 10);
    }

    @Override
    public void attack(Monster target, Character user) {
        int dmg = (int) (this.getValue()*(0.5*user.getIntellect() + 0.2*user.getAgility()));
        target.setHealth(target.getHealth() - dmg);
        user.setMana(user.getMana() - getCost());
        System.out.println(user.getName() + " used skill Holy Hammer and hit the target for " + dmg + " damage!");
    }
}
