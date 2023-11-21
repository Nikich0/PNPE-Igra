package game.petskills;

import game.monsters.Monster;
import game.pets.Pets;
import game.characters.Character;

public class Claw extends PetSkills {

    public Claw() {
        super(5, 1);
    }

    @Override
    public void attack(Monster target, Pets user) {
        int dmg = this.getValue();
        target.setHealth((int) (target.getHealth() - dmg*(0.1*user.getPower())));
        user.setMana(user.getMana() - getCost());
        System.out.println(user.getType() + " used skill Claw and hit the target for " + (int)(dmg*(0.3*user.getPower())) + " damage!");
    }
}
