package game.items;

import java.util.Random;

public class Hat extends Item implements IUsableByNecromancer, IUsableByWitch{

    private String[] _prefix = new String[] {"Basic", "Rare", "Epic", "Legendary"};
    public Hat(String name) {
        super(ItemType.Hat, name, 10, 5, 18,0);
        Random rand = new Random();
        int index = rand.nextInt(4);
        int stamina = (int)((0.75 + (index*0.25))*10);
        int agility = (int)((0.5 + (index*0.25))*5);
        int intellect = (int)((1 + (index*0.25))*18);
        this.setName(String.format("%s %s",this._prefix[index], name));
        this.setStamina(stamina);
        this.setAgility(agility);
        this.setIntellect(intellect);
        this.setIndex(index);
    }
}
