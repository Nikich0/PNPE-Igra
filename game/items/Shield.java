package game.items;

import java.util.Random;

public class Shield extends Item implements IUsableByPaladin{
    private String[] _prefix = new String[] {"Basic", "Rare", "Epic", "Legendary"};

    public Shield(String name) {
        super(ItemType.Shield, name, 20, 5, 8,0);
        Random rand = new Random();
        int index = rand.nextInt(4);
        int stamina = (int)((1 + (index*0.25))*20);
        int agility = (int)((0.5 + (index*0.25))*5);
        int intellect = (int)((0.75 + (index*0.25))*8);
        this.setName(String.format("%s %s",this._prefix[index], name));
        this.setStamina(stamina);
        this.setAgility(agility);
        this.setIntellect(intellect);
        this.setIndex(index);
    }
}
