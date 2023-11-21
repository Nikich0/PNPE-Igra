package game.characters;

import game.items.Item;
import game.items.ItemType;
import game.monsters.Monster;

public class Necromancer extends Character {

    private Item weapon;
    private Item head;
    private Item chest;
    private Item legs;
    private Item feet;
    public Necromancer(String name){
        super(name, 60, 8, 150,"Dwarf",10,10,10);
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Item getHead() {
        return head;
    }

    public void setHead(Item head) {
        this.head = head;
    }

    public Item getChest() {
        return chest;
    }

    public void setChest(Item chest) {
        this.chest = chest;
    }

    public Item getLegs() {
        return legs;
    }

    public void setLegs(Item legs) {
        this.legs = legs;
    }

    public Item getFeet() {
        return feet;
    }

    public void setFeet(Item feet) {
        this.feet = feet;
    }
    int health1 = 60;
    int mana1 = 150;
    int power1 = 8;

    @Override
    public void setStats()
    {
        setHealth(getHealth() + getStamina());
        setPower((int) (getPower()*(0.1*getAgility())));
        setMana(getMana() + 2*getIntellect());
    }

    @Override
    public void resetStats() {
        setHealth(health1);
        setPower(power1);
        setMana(mana1);
    }

    @Override
    public void pickItem(Item item) {
        if(item.getType() == ItemType.Staff && this.weapon == null)
        {
            setWeapon(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.Staff && this.weapon != null)
        {
            if(weapon.getIndex() >= item.getIndex())
            {
                System.out.println("Your current item is better or the same!");
                item.itemDetails();
            }
            else
            {
                setStamina(getStamina() - weapon.getStamina());
                setAgility(getAgility() - weapon.getAgility());
                setIntellect(getIntellect() - weapon.getIntellect());
                setWeapon(item);
                setStamina(getStamina() + item.getStamina());
                setAgility(getAgility() + item.getAgility());
                setIntellect(getIntellect() + item.getIntellect());
                item.itemDetails();
                System.out.println("New item equipped!");
            }
        }
        else if(item.getType() == ItemType.Hat && this.head == null)
        {
            setHead(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.Hat && this.head != null)
        {
            if(head.getIndex() >= item.getIndex())
            {
                System.out.println("Your current item is better or the same!");
                item.itemDetails();
            }
            else
            {
                setStamina(getStamina() - head.getStamina());
                setAgility(getAgility() - head.getAgility());
                setIntellect(getIntellect() - head.getIntellect());
                setHead(item);
                setStamina(getStamina() + item.getStamina());
                setAgility(getAgility() + item.getAgility());
                setIntellect(getIntellect() + item.getIntellect());
                item.itemDetails();
                System.out.println("New item equipped!");
            }
        }
        else if(item.getType() == ItemType.Robe && this.chest == null)
        {
            setChest(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.Robe && this.chest != null)
        {
            if(chest.getIndex() >= item.getIndex())
            {
                System.out.println("Your current item is better or the same!");
                item.itemDetails();
            }
            else
            {
                setStamina(getStamina() - chest.getStamina());
                setAgility(getAgility() - chest.getAgility());
                setIntellect(getIntellect() - chest.getIntellect());
                setChest(item);
                setStamina(getStamina() + item.getStamina());
                setAgility(getAgility() + item.getAgility());
                setIntellect(getIntellect() + item.getIntellect());
                item.itemDetails();
                System.out.println("New item equipped!");
            }
        }
        else if(item.getType() == ItemType.Shorts && this.legs == null)
        {
            setLegs(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.Shorts && this.legs != null)
        {
            if(legs.getIndex() >= item.getIndex())
            {
                System.out.println("Your current item is better or the same!");
                item.itemDetails();
            }
            else
            {
                setStamina(getStamina() - legs.getStamina());
                setAgility(getAgility() - legs.getAgility());
                setIntellect(getIntellect() - legs.getIntellect());
                setLegs(item);
                setStamina(getStamina() + item.getStamina());
                setAgility(getAgility() + item.getAgility());
                setIntellect(getIntellect() + item.getIntellect());
                item.itemDetails();
                System.out.println("New item equipped!");
            }
        }
        else if(item.getType() == ItemType.ClothBoots && this.feet == null)
        {
            setFeet(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.ClothBoots && this.feet != null)
        {
            if(feet.getIndex() >= item.getIndex())
            {
                System.out.println("Your current item is better or the same!");
                item.itemDetails();
            }
            else
            {
                setStamina(getStamina() - feet.getStamina());
                setAgility(getAgility() - feet.getAgility());
                setIntellect(getIntellect() - feet.getIntellect());
                setFeet(item);
                setStamina(getStamina() + item.getStamina());
                setAgility(getAgility() + item.getAgility());
                setIntellect(getIntellect() + item.getIntellect());
                item.itemDetails();
                System.out.println("New item equipped!");
            }
        }
    }

    @Override
    public void attack(Monster target) {
        int atp = this.getPower();
        target.setHealth(target.getHealth() - atp);
        System.out.println(this.getName() + " hit the target with the weapon for " + atp + " damage!");
    }

    @Override
    public void defend(int atp) {
        int health = this.getHealth();
        this.setHealth(health - atp);
    }
}
