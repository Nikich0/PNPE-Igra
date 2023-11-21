package game.monsters;

import game.characters.Character;

public class Butcher extends Monster implements IsAtackable {

    public Butcher() {
        super("The Butcher", 180, 12, "Undead");
    }

    @Override
    public void attack(Character target) {
        int atp = this.getPower();
        target.setHealth(target.getHealth() - atp);
    }
}
