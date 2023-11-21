package game.characters;

import game.items.Item;
import game.items.ItemType;
import game.monsters.Monster;

public class Barbarian extends Character {
    private Item rightHand;
    private Item leftHand;
    private Item head;
    private Item chest;
    private Item legs;
    private Item feet;
    public Barbarian(String name) {
        super(name, 80, 15,80, "Orc",10,10,10);
    }

    public Item getRightHand() {
        return rightHand;
    }

    public void setRightHand(Item rightHand) {
        this.rightHand = rightHand;
    }

    public Item getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Item leftHand) {
        this.leftHand = leftHand;
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
    int health1 = 80;
    int mana1 = 80;
    int power1 = 15;

    @Override
    public void setStats()
    {
        setHealth(getHealth() + getStamina());
        setPower((int) (getPower()*(0.11*getAgility())));
        setMana(getMana() + getIntellect());
    }

    @Override
    public void resetStats() {
        setHealth(health1);
        setPower(power1);
        setMana(mana1);
    }

    @Override
    public void pickItem(Item item) {
        if(item.getType() == ItemType.Axe && this.rightHand == null)
        {
            setRightHand(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.Axe && this.rightHand != null)
        {
            if(rightHand.getIndex() >= item.getIndex())
            {
                System.out.println("Your current item is better or the same!");
                item.itemDetails();
            }
            else
            {
                setStamina(getStamina() - rightHand.getStamina());
                setAgility(getAgility() - rightHand.getAgility());
                setIntellect(getIntellect() - rightHand.getIntellect());
                setRightHand(item);
                setStamina(getStamina() + item.getStamina());
                setAgility(getAgility() + item.getAgility());
                setIntellect(getIntellect() + item.getIntellect());
                item.itemDetails();
                System.out.println("New item equipped!");
            }
        }
        else if(item.getType() == ItemType.Sword && this.leftHand == null)
        {
            setLeftHand(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.Sword && this.leftHand != null)
        {
            if(leftHand.getIndex() >= item.getIndex())
            {
                System.out.println("Your current item is better or the same!");
                item.itemDetails();
            }
            else
            {
                setStamina(getStamina() - leftHand.getStamina());
                setAgility(getAgility() - leftHand.getAgility());
                setIntellect(getIntellect() - leftHand.getIntellect());
                setLeftHand(item);
                setStamina(getStamina() + item.getStamina());
                setAgility(getAgility() + item.getAgility());
                setIntellect(getIntellect() + item.getIntellect());
                item.itemDetails();
                System.out.println("New item equipped!");
            }
        }
        else if(item.getType() == ItemType.Helmet && this.head == null)
        {
            setHead(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.Helmet && this.head != null)
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
        else if(item.getType() == ItemType.ChestPlate && this.chest == null)
        {
            setChest(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.ChestPlate && this.chest != null)
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
        else if(item.getType() == ItemType.Leggings && this.legs == null)
        {
            setLegs(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.Leggings && this.legs != null)
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
        else if(item.getType() == ItemType.Boots && this.feet == null)
        {
            setFeet(item);
            setStamina(getStamina() + item.getStamina());
            setAgility(getAgility() + item.getAgility());
            setIntellect(getIntellect() + item.getIntellect());
            item.itemDetails();
            System.out.println("New item equipped!");
        }
        else if(item.getType() == ItemType.Boots && this.feet != null)
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
