package game.monsters;

import game.characters.Character;

public class SkeletonKing extends Monster implements IsAtackable {

    public SkeletonKing() {
        super("The Skeleton King", 260, 7, "Undead");
    }

    @Override
    public void attack(Character target) {
        int atp = this.getPower();
        target.setHealth(target.getHealth() - atp);
    }
}
