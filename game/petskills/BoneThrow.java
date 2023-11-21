package game.petskills;

import game.monsters.Monster;
import game.pets.Pets;
import game.characters.Character;

public class BoneThrow extends PetSkills{

    public BoneThrow() {
        super(1, 1);
    }

    @Override
    public void attack(Monster target, Pets user) {
        int dmg = this.getValue();
        target.setHealth((int) (target.getHealth() - (3*(dmg*(0.4*user.getPower())))));
        user.setMana(user.getMana() - getCost());
        System.out.println(user.getType() + " used skill Bone Throw and hit the target for " + (int)(3*(dmg*(0.4*user.getPower()))) + " damage!");
    }
}


