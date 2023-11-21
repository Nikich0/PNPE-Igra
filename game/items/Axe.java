package game.items;

import java.util.Random;

public class Axe extends Item implements IUsableByBarbarian{

    private String[] _prefix = new String[] {"Basic", "Rare", "Epic", "Legendary"};
    public Axe(String name) {
        super(ItemType.Axe, name, 10, 15, 5,0);
        Random rand = new Random();
        int index = rand.nextInt(4);
        int stamina = (int)((0.75 + (index*0.25))*10);
        int agility = (int)((1 + (index*0.25))*15);
        int intellect = (int)((0.5 + (index*0.25))*5);
        this.setName(String.format("%s %s",this._prefix[index], name));
        this.setStamina(stamina);
        this.setAgility(agility);
        this.setIntellect(intellect);
        this.setIndex(index);
    }
}
