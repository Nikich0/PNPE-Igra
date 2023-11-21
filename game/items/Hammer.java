package game.items;
import java.util.Random;
public class Hammer extends Item implements IUsableByPaladin{
    private String[] _prefix = new String[] {"Basic", "Rare", "Epic", "Legendary"};
    public Hammer(String name) {
        super(ItemType.Hammer, name, 10, 10, 10,0);
        Random rand = new Random();
        int index = rand.nextInt(4);
        int stamina = (int)((0.75 + (index*0.25))*10);
        int agility = (int)((0.75 + (index*0.25))*10);
        int intellect = (int)((0.75 + (index*0.25))*10);
        this.setName(String.format("%s %s",this._prefix[index], name));
        this.setStamina(stamina);
        this.setAgility(agility);
        this.setIntellect(intellect);
        this.setIndex(index);
    }

}
