package game.items;

import java.util.Random;

public class Bow extends Item implements IUsableByAmazon{

    private String[] _prefix = new String[] {"Basic", "Rare", "Epic", "Legendary"};
    public Bow(String name) {
        super(ItemType.Bow, name, 7, 20, 7,0);
        Random rand = new Random();
        int index = rand.nextInt(4);
        int stamina = (int)((0.75 + (index*0.25))*7);
        int agility = (int)((1 + (index*0.25))*20);
        int intellect = (int)((0.75 + (index*0.25))*7);
        this.setName(String.format("%s %s",this._prefix[index], name));
        this.setStamina(stamina);
        this.setAgility(agility);
        this.setIntellect(intellect);
        this.setIndex(index);
    }
}
