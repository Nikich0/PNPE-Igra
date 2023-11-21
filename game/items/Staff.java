package game.items;

import java.util.Random;

public class Staff extends Item implements IUsableByNecromancer, IUsableByWitch{
    private String[] _prefix = new String[] {"Basic", "Rare", "Epic", "Legendary"};
    public Staff(String name) {
        super(ItemType.Staff, name, 7, 5, 25,0);
        Random rand = new Random();
        int index = rand.nextInt(4);
        int stamina = (int)((0.75 + (index*0.25))*7);
        int agility = (int)((0.5 + (index*0.25))*5);
        int intellect = (int)((1 + (index*0.25))*25);
        this.setName(String.format("%s %s",this._prefix[index], name));
        this.setStamina(stamina);
        this.setAgility(agility);
        this.setIntellect(intellect);
        this.setIndex(index);
    }
}
