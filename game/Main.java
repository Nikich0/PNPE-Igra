package game;
import game.characters.*;
import game.characters.Character;
import game.monsters.*;
import game.pets.Pets;
import game.pets.SaberTooth;
import game.pets.Skeletons;
import game.skills.*;
import game.skills.Skills;
import game.petskills.*;
import game.petskills.PetSkills;
import game.items.Item;
import game.items.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's create your character!");
        System.out.println("Please type your character name:");
        String name = scanner.nextLine();
        System.out.println("Choose your character Class! 1 - \u001B[35m Paladin \u001B[0m, 2 - \u001B[32m Amazon \u001B[0m, 3 - \u001B[31m Barbarian \u001B[0m, 4 - \u001B[36m Necromancer \u001B[0m, 5 - \u001B[33m Witch \u001B[0m");
        int x = scanner.nextInt();
        do {
            if (x >= 1 && x <= 5)
            {
                break;
            }
            else
            {
                System.out.println("Invalid number! Please select one of the usable Characters!");
                System.out.println("1 - Paladin, 2 - Amazon, 3 - Barbarian, 4 - Necromancer, 5 - Witch");
                x = scanner.nextInt();
            }
        }while(x < 1 || x > 5);
        Character ch = create(x, name);
        ch.setStats();
        ch.introduce();
        Pets p = null;
        if(x == 2 || x == 4)
        {
            p = summon(x);
            p.setPetStats(ch);
        }

        Skills s1 = createSkill(x);
        PetSkills ps1 = createPetSkill(x);

        int q = 0;

        do {
            gameMenu();
            q = scanner.nextInt();
            if(q > 0 || q < 5) {
                switch (q) {
                    case 1:
                        Monster m = createMonster();
                        battle(ch, m, x, p, s1, ps1);
                        break;
                    case 2:
                        printStats(ch);
                        break;
                    case 3:
                        printInventory(ch, x);
                        break;
                    case 4:
                        break;
                    default:

                }
            }
            else{
                System.out.println("Choose a correct option from the menu!");
                gameMenu();
                q = scanner.nextInt();
            }

        }while(q != 4);

        scanner.close();
    }
    public static void battle(Character ch, Monster m, int x, Pets p, Skills s1, PetSkills ps1)
    {
        System.out.println("You encountered a monster!");
        System.out.println(m.getName() + " has " + m.getHealth() + " health!");
        if(m instanceof IsAtackable) {
            if (x == 2 || x == 4) {
                int he1 = ch.getHealth();
                int ma1 = ch.getMana();
                int hep1 = p.getHealth();
                int map1 = p.getMana();
                while ((ch.isAlive()) && (m.isAlive())) {
                    ch.attack(m);
                    if(ch.enoughMana())
                    {
                        s1.attack(m, ch);
                    }
                    else
                    {
                        System.out.println(ch.getName() + " doesn't have enough mana to use a skill!");
                    }
                    p.attack(m);
                    if(p.enoughMana())
                    {
                        ps1.attack(m, p);
                    }
                    else
                    {
                        System.out.println(p.getType() + " doesn't have enough mana to use a skill!");
                    }
                    if (m.isAlive()) {
                        System.out.println(m.getName() + " has " + m.getHealth() + " health!");
                        System.out.println(m.getName() + " attacks back!");
                        m.attack(ch);
                        if (!ch.isAlive()) {
                            System.out.println("You are dead!");
                        } else {
                            System.out.println(ch.getName() + " has " + ch.getHealth() + " health and " + ch.getMana() + " mana!");
                        }
                    } else {
                        System.out.println(ch.getName() + " has defeated the monster!");
                        Random rand = new Random();
                        int itemN = rand.nextInt(14);
                        Item i1 = createItem(itemN);
                        System.out.println("Resting!");
                        ch.setHealth(he1);
                        ch.setMana(ma1);
                        p.setHealth(hep1);
                        p.setMana(map1);
                        usable(x, i1, ch, p);
                    }
                }
            } else {
                int he1 = ch.getHealth();
                int ma1 = ch.getMana();
                while ((ch.isAlive()) && (m.isAlive())) {
                    ch.attack(m);
                    if(ch.getMana() > 0)
                    {
                        s1.attack(m, ch);
                    }
                    else
                    {
                        System.out.println(ch.getName() + " doesn't have enough mana to use a skill!");
                    }
                    if (m.isAlive()) {
                        System.out.println(m.getName() + " has " + m.getHealth() + " health!");
                        System.out.println(m.getName() + " attacks back!");
                        m.attack(ch);
                        if (!ch.isAlive()) {
                            System.out.println("You are dead!");
                        } else {
                            System.out.println(ch.getName() + " has " + ch.getHealth() + " health and " + ch.getMana() + " mana!");
                        }
                    } else {
                        System.out.println(ch.getName() + " has defeated the monster!");
                        Random rand = new Random();
                        int itemN = rand.nextInt(14);
                        Item i1 = createItem(itemN);
                        System.out.println("Resting!");
                        ch.setHealth(he1);
                        ch.setMana(ma1);
                        usable(x, i1, ch, p);
                    }
                }
            }
        }
        else
        {
            m.attack(ch);
        }
    }

    public static Character create(int x, String name)
    {
        switch (x)
        {
            case 1:
                System.out.println("You chose Paladin as your class!");
                return new Paladin(name);
            case 2:
                System.out.println("You chose Amazon as your class!");
                return new Amazon(name);
            case 3:
                System.out.println("You chose Barbarian as your class!");
                return new Barbarian(name);
            case 4:
                System.out.println("You chose Necromancer as your class!");
                return new Necromancer(name);
            case 5:
                System.out.println("You chose Witch as your class!");
                return new Witch(name);
            default:
                return null;
        }
    }
    public static Pets summon(int x) {
        switch (x) {
            case 2:
                System.out.println("Your Amazon summoned pet SaberTooth!");
                return new SaberTooth();
            case 4:
                System.out.println("Your Necromancer summoned Skeletons!");
                return new Skeletons();

            default:
                return null;
        }
    }
    public static Skills createSkill(int x)
    {
        switch (x)
        {
            case 1:
                return new HolyHammer();
            case 2:
                return new AimShot();
            case 3:
                return new AxeThrow();
            case 4:
                return new ChaosBolt();
            case 5:
                return new Pyroblast();
            default:
                return null;
        }
    }
    public static PetSkills createPetSkill(int x)
    {
        switch(x)
        {
            case 2:
                return new Claw();
            case 4:
                return new BoneThrow();
            default:
                return null;
        }
    }
    public static Item createItem(int rand)
    {
        switch (rand)
        {
            case 0:
                return new Hammer("Hammer");
            case 1:
                return new Shield("Shield");
            case 2:
                return new Axe("Axe");
            case 3:
                return new Sword("Sword");
            case 4:
                return new Bow("Bow");
            case 5:
                return new Staff("Staff");
            case 6:
                return new Helmet("Helmet");
            case 7:
                return new ChestPlate("Chest Plate");
            case 8:
                return new Leggings("Leggings");
            case 9:
                return new Boots("Boots");
            case 10:
                return new Hat("Hat");
            case 11:
                return new Robe("Robe");
            case 12:
                return new Shorts("Shorts");
            case 13:
                return new ClothBoots("Cloth Boots");
            default:
                return null;
        }
    }
    public static void usable(int x, Item i1, Character user, Pets p)
    {
        switch (x)
        {
            case 1:
                if(i1 instanceof IUsableByPaladin)
                {
                    user.resetStats();
                    user.pickItem(i1);
                    user.setStats();
                    break;
                }
                else
                {
                    System.out.println("The item is unusable by this class!");
                    break;
                }
            case 2:
                if(i1 instanceof IUsableByAmazon)
                {
                    user.resetStats();
                    p.resetPetStats();
                    user.pickItem(i1);
                    user.setStats();
                    p.setPetStats(user);
                    break;
                }
                else
                {
                    System.out.println("The item is unusable by this class!");
                    break;
                }
            case 3:
                if(i1 instanceof IUsableByBarbarian)
                {
                    user.resetStats();
                    user.pickItem(i1);
                    user.setStats();
                    break;
                }
                else
                {
                    System.out.println("The item is unusable by this class!");
                    break;
                }
            case 4:
                if(i1 instanceof IUsableByNecromancer)
                {
                    user.resetStats();
                    p.resetPetStats();
                    user.pickItem(i1);
                    user.setStats();
                    p.setPetStats(user);
                    break;
                }
                else
                {
                    System.out.println("The item is unusable by this class!");
                    break;
                }
            case 5:
                if(i1 instanceof IUsableByWitch)
                {
                    user.resetStats();
                    user.pickItem(i1);
                    user.setStats();
                    break;
                }
                else
                {
                    System.out.println("The item is unusable by this class!");
                    break;
                }
            default:
        }
    }

    public static void gameMenu() {

        System.out.println("\u001B[34m Game Menu \u001B[0m");
        System.out.println("\u001B[34m 1.Fight Monster \u001B[0m");
        System.out.println("\u001B[34m 2.Check Stats \u001B[0m");
        System.out.println("\u001B[34m 3.Check Inventory \u001B[0m");
        System.out.println("\u001B[34m 4.Exit Game \u001B[0m");
        System.out.println("Be careful! If you exit the game all progress will be lost forever!");
    }

    public static void printStats(Character user)
    {
        System.out.println("The character " + user.getName() + " has:");
        System.out.println("Health: " + user.getHealth());
        System.out.println("Power: " + user.getPower());
        System.out.println("Mana: " + user.getMana());
        System.out.println("Stamina: " + user.getStamina());
        System.out.println("Agility: " + user.getAgility());
        System.out.println("Intellect: " + user.getIntellect());
    }

    public static Monster createMonster()
    {
        Random rand = new Random();
        int rand1 = rand.nextInt(3);
        switch (rand1)
        {
            case 0:
                return new FallenShaman();
            case 1:
                return new Butcher();
            case 2:
                return new SkeletonKing();
            default:
                return null;
        }
    }

    public static void printInventory(Character user, int x)
    {
        if(x == 1){
            invPaladin((Paladin) user);
        }
        else if(x == 2) {
            invAmazon((Amazon) user);
        }
        else if(x == 3) {
            invBarbarian((Barbarian) user);
        }
        else if(x == 4) {
            invNecromancer((Necromancer) user);
        }
        else if(x == 5) {
            invWitch((Witch) user);
        }
    }

    public static void invPaladin(Paladin user)
    {
        if(user.getRightHand() != null) {
            System.out.println("Right Hand: " + user.getRightHand().getName());
        }
        else{
            System.out.println("Right Hand: Item slot is empty!" );
        }
        if(user.getLeftHand() != null) {
            System.out.println("Left Hand: " + user.getLeftHand().getName());
        }
        else{
            System.out.println("Left Hand: Item slot is empty!" );
        }
        if(user.getHead() != null) {
            System.out.println("Head: " + user.getHead().getName());
        }
        else{
            System.out.println("Head: Item slot is empty!" );
        }
        if(user.getChest() != null) {
            System.out.println("Chest: " + user.getChest().getName());
        }
        else{
            System.out.println("Chest: Item slot is empty!" );
        }
        if(user.getLegs() != null) {
            System.out.println("Legs: " + user.getLegs().getName());
        }
        else{
            System.out.println("Legs: Item slot is empty!" );
        }
        if(user.getFeet() != null) {
            System.out.println("Feet: " + user.getFeet().getName());
        }
        else{
            System.out.println("Feet: Item slot is empty!" );
        }
    }

    public static void invBarbarian(Barbarian user)
    {
        if(user.getRightHand() != null) {
            System.out.println("Right Hand: " + user.getRightHand().getName());
        }
        else{
            System.out.println("Right Hand: Item slot is empty!" );
        }
        if(user.getLeftHand() != null) {
            System.out.println("Left Hand: " + user.getLeftHand().getName());
        }
        else{
            System.out.println("Left Hand: Item slot is empty!" );
        }
        if(user.getHead() != null) {
            System.out.println("Head: " + user.getHead().getName());
        }
        else{
            System.out.println("Head: Item slot is empty!" );
        }
        if(user.getChest() != null) {
            System.out.println("Chest: " + user.getChest().getName());
        }
        else{
            System.out.println("Chest: Item slot is empty!" );
        }
        if(user.getLegs() != null) {
            System.out.println("Legs: " + user.getLegs().getName());
        }
        else{
            System.out.println("Legs: Item slot is empty!" );
        }
        if(user.getFeet() != null) {
            System.out.println("Feet: " + user.getFeet().getName());
        }
        else{
            System.out.println("Feet: Item slot is empty!" );
        }
    }
    public static void invAmazon(Amazon user)
    {
        if(user.getWeapon() != null) {
            System.out.println("Weapon: " + user.getWeapon().getName());
        }
        else{
            System.out.println("Weapon: Item slot is empty!" );
        }
        if(user.getHead() != null) {
            System.out.println("Head: " + user.getHead().getName());
        }
        else{
            System.out.println("Head: Item slot is empty!" );
        }
        if(user.getChest() != null) {
            System.out.println("Chest: " + user.getChest().getName());
        }
        else{
            System.out.println("Chest: Item slot is empty!" );
        }
        if(user.getLegs() != null) {
            System.out.println("Legs: " + user.getLegs().getName());
        }
        else{
            System.out.println("Legs: Item slot is empty!" );
        }
        if(user.getFeet() != null) {
            System.out.println("Feet: " + user.getFeet().getName());
        }
        else{
            System.out.println("Feet: Item slot is empty!" );
        }
    }

    public static void invNecromancer(Necromancer user)
    {
        if(user.getWeapon() != null) {
            System.out.println("Weapon: " + user.getWeapon().getName());
        }
        else{
            System.out.println("Weapon: Item slot is empty!" );
        }
        if(user.getHead() != null) {
            System.out.println("Head: " + user.getHead().getName());
        }
        else{
            System.out.println("Head: Item slot is empty!" );
        }
        if(user.getChest() != null) {
            System.out.println("Chest: " + user.getChest().getName());
        }
        else{
            System.out.println("Chest: Item slot is empty!" );
        }
        if(user.getLegs() != null) {
            System.out.println("Legs: " + user.getLegs().getName());
        }
        else{
            System.out.println("Legs: Item slot is empty!" );
        }
        if(user.getFeet() != null) {
            System.out.println("Feet: " + user.getFeet().getName());
        }
        else{
            System.out.println("Feet: Item slot is empty!" );
        }
    }
    public static void invWitch(Witch user)
    {
        if(user.getWeapon() != null) {
            System.out.println("Weapon: " + user.getWeapon().getName());
        }
        else {
            System.out.println("Weapon: Item slot is empty!" );
        }

        if(user.getHead() != null) {
            System.out.println("Head: " + user.getHead().getName());
        }
        else {
            System.out.println("Head: Item slot is empty!" );
        }

        if(user.getChest() != null) {
            System.out.println("Chest: " + user.getChest().getName());
        }
        else {
            System.out.println("Chest: Item slot is empty!" );
        }

        if(user.getLegs() != null) {
            System.out.println("Legs: " + user.getLegs().getName());
        }
        else {
            System.out.println("Legs: Item slot is empty!" );
        }

        if(user.getFeet() != null) {
            System.out.println("Feet: " + user.getFeet().getName());
        }
        else{
            System.out.println("Feet: Item slot is empty!" );
        }
    }
}


