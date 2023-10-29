package src.com.clirpg.game;

import java.util.Random;
import java.util.Scanner;

import src.com.clirpg.characters.*;

public class Round {
    private int level;
    private Player player;
    private Soldier roundSoldierArray[];
    private int currentSoldierNumber = 0;
    private Monster roundMonsterArray[];
    private int currentMonsterNumber = 0;
    

    public Round(int level)
    {
        this.level = level;
        this.roundSoldierArray = new Soldier [1000];
        this.roundMonsterArray = new Monster [1000];
    }

    public Round(int level, Player player)
    {
        this.level = level;
        this.player = player;
        this.roundSoldierArray = new Soldier [1000];
        this.roundMonsterArray = new Monster [1000];
    }

    public int getLevel()
    {
        return this.level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public void startRound()
    {
        Random random = new Random();
        //System.out.println("started round at level: " + this.getLevel());
        // Get enemies
        int soldierNumber = 0;
        int monsterNumber = 0;
        // Generate a random double between 0 (inclusive) and 1 (exclusive)
        for (int i = this.getLevel(); i > 0; i--) {
            //System.out.println(i);
            // chane do disable monsters
            int randomNumber = random.nextInt(1);
            //System.out.println(randomNumber);
            switch (randomNumber) {
                case 0:
                    soldierNumber++;
                    break;
                case 1:
                    monsterNumber++;
                    i-=2;
                    break;
            }
        }
        //System.out.println("remainder = " + (this.getLevel() - (soldierNumber + (monsterNumber * 3))));
        //System.out.println("soldier number = " + soldierNumber);
        //System.out.println("monster number = " + monsterNumber);

        for (int i = soldierNumber; i > 0; i--) {
            //System.out.println(i);
            int randomNumber = random.nextInt(10);
            //System.out.println(randomNumber);
            switch (randomNumber) {
                case 0:
                    appendSoldier(new Soldier("Billy"));
                    break;
                case 1:
                    appendSoldier(new Soldier("Brian"));
                    break;
                case 2:
                    appendSoldier(new Soldier("Luc"));
                    break;
                case 3:
                    appendSoldier(new Soldier("Matthew"));
                    break;
                case 4:
                    appendSoldier(new Soldier("Mary"));
                    break;
                case 5:
                    appendSoldier(new Soldier("Antoinette"));
                    break;
                case 6:
                    appendSoldier(new Soldier("James"));
                    break;
                case 7:
                    appendSoldier(new Soldier("Ryan"));
                    break;
                case 8:
                    appendSoldier(new Soldier("Robert"));
                    break;
                case 9:
                    appendSoldier(new Soldier("Edward"));
                    break;
            }
        }

        for (int i = monsterNumber; i > 0; i--) {
            //System.out.println(i);
            int randomNumber = random.nextInt(10);
            //System.out.println(randomNumber);
            switch (randomNumber) {
                case 0:
                    appendMonster(new Monster("Balrog"));
                    break;
                case 1:
                    appendMonster(new Monster("Banshee"));
                    break;
                case 2:
                    appendMonster(new Monster("Lockjaw"));
                    break;
                case 3:
                    appendMonster(new Monster("DiamondHead"));
                    break;
                case 4:
                    appendMonster(new Monster("Ogre"));
                    break;
                case 5:
                    appendMonster(new Monster("Witch"));
                    break;
                case 6:
                    appendMonster(new Monster("ManEater"));
                    break;
                case 7:
                    appendMonster(new Monster("Basilisk"));
                    break;
                case 8:
                    appendMonster(new Monster("Zombie"));
                    break;
                case 9:
                    appendMonster(new Monster("Warg"));
                    break;                                                            
            }
        }
        this.roundLoop();
    }

    public void roundLoop() {
        Scanner choiceReader = new Scanner(System.in);
        
        while (player.health > 0) {
            System.out.println(this.toString());
            System.out.println("Enter '1' to attack soldier");
            System.out.println("Enter '2' to attack monster");
            int choice = choiceReader.nextInt();
    
            // Check the value of 'choice' and perform actions accordingly
            switch (choice) {
                case 1:
                    // Code to attack a soldier
                    // For example: player.attackSoldier();
                    System.out.println("player chooses soldier");
                    System.out.println("choose soldier 0-" + (currentSoldierNumber - 1));
                    choice = choiceReader.nextInt();
                    while ((choice > (currentSoldierNumber - 1)) || (choice < 0))
                    {
                        System.out.println("Invalid integer, pick again");
                        System.out.println("choose soldier 0-" + (currentSoldierNumber - 1));
                        choice = choiceReader.nextInt();
                    }
                    System.out.println("selected soldier: " + roundSoldierArray[choice].toString());
                    roundSoldierArray[choice].setHealth(player.combat());
                    break;
                case 2:
                    // Code to attack a monster
                    // For example: player.attackMonster();
                    System.out.println("player chooses Monster");
                    System.out.println("choose Monster 0-" + (currentMonsterNumber - 1));
                    choice = choiceReader.nextInt();
                    while ((choice > (currentMonsterNumber - 1)) || (choice < 0))
                    {
                        System.out.println("Invalid integer, pick again");
                        System.out.println("choose Monster 0-" + (currentMonsterNumber - 1));
                        choice = choiceReader.nextInt();
                    }
                    System.out.println("selected Monster: " + roundMonsterArray[choice].toString());
                    roundMonsterArray[choice].setHealth(player.combat());
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
            checkAndUpdate();
        }
    }
    
    public int checkAndUpdate()
    {
        for (int i = 0; i < currentSoldierNumber; i++)
        {
            if (roundSoldierArray[i] != null)
            {
                if (roundSoldierArray[i].health <= 0)
                {
                    System.out.println(roundSoldierArray[i].name + " died");
                    removeSoldier(i);
                    return 1;
                }
            }
            else
            {
                System.out.println("soldier lost error at " + i);
                return 0;
            }
        }
        return 0;
    }

    public void removeSoldier(int toRemove)
    {
        Soldier[] tmpRoundSoldierArray = roundSoldierArray;
        int tmpSoldierNumber = currentSoldierNumber;
        System.out.println("target to remove " + tmpRoundSoldierArray[toRemove]);
        this.roundSoldierArray = new Soldier [1000];
        this.currentSoldierNumber = 0;
        for (int i = 0; (i < tmpSoldierNumber); i++)
        {
            System.out.println("adding: " + tmpRoundSoldierArray[i]);
            if(i != toRemove)
            {
                appendSoldier(tmpRoundSoldierArray[i]);
            }
        }
    }

    public void appendMonster(Monster newMonster) {
        if (currentMonsterNumber < roundMonsterArray.length) {
            roundMonsterArray[currentMonsterNumber] = newMonster;
            currentMonsterNumber++; // Increment the count of Monsters in the array
        } else {
            // Handle the case where the array is full and cannot append more Monsters
            System.out.println("The array is full. Cannot append more Monsters.");
        }
    }

    public void appendSoldier(Soldier newSoldier) {
        if (currentSoldierNumber < roundSoldierArray.length) {
            roundSoldierArray[currentSoldierNumber] = newSoldier;
            currentSoldierNumber++; // Increment the count of soldiers in the array
        } else {
            // Handle the case where the array is full and cannot append more soldiers
            System.out.println("The array is full. Cannot append more soldiers.");
        }
    }

    public String toString() {
        String toPrint = this.player.toString() + "\n";
        for (int i = 0; i < currentSoldierNumber; i++) {
            if (roundSoldierArray[i] != null) {
                toPrint = toPrint + "[" + i + "]:" + roundSoldierArray[i].toString() + ", ";
            }
            else
            {
                //System.out.println("soldier lost");
            }
        }
        toPrint = toPrint + "\n";
        for (int i = 0; i < currentMonsterNumber; i++) {
            if (roundMonsterArray[i] != null) {
                toPrint = toPrint + "[" + i + "]:" + roundMonsterArray[i].toString() + ", ";
            }
            else
            {
                //System.out.println("monster lost");
            }
        }
        return toPrint;
    }
    
}
