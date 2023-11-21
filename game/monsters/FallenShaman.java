package game.monsters;

import game.characters.Character;

public class FallenShaman extends Monster implements IsAtackable {


    public FallenShaman() {
        super("The Fallen One", 200, 9, "Undead");
    }

    @Override
    public void attack(Character target) {
        int atp = this.getPower();
        target.setHealth(target.getHealth() - atp);
    }
}
