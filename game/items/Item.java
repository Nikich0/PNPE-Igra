package game.items;

public abstract class Item {
    private ItemType type;
    private String name;
    private int stamina;
    private int agility;
    private int intellect;
    private int index;

    public Item(ItemType type, String name, int stamina, int agility, int intellect, int index) {
        this.type = type;
        this.name = name;
        this.stamina = stamina;
        this.agility = agility;
        this.intellect = intellect;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void itemDetails()
    {
        System.out.println(String.format("You obtained %s with %d stamina, %d agility and %d intellect!", getName(), getStamina(), getAgility(), getIntellect()));
    }

}
