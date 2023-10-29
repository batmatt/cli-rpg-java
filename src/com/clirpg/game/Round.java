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

    public int startRound()
    {
        player.health = 100;
        Random random = new Random();
        //System.out.println("started round at level: " + this.getLevel());
        // Get enemies
        int soldierNumber = 0;
        int monsterNumber = 0;
        // Generate a random double between 0 (inclusive) and 1 (exclusive)
        for (int i = this.getLevel(); i > 0; i--) {
            //System.out.println(i);
            // chane do disable monsters
            int randomNumber = random.nextInt(2);
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
        if(player.health >= 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public void roundLoop() {
        Scanner choiceReader = new Scanner(System.in);
        int enemiesRemain = 1;
        int playerAlive = 1;

        while ((enemiesRemain == 1) && (playerAlive == 1))
        {
            System.out.println("~~~~~~~~~~~~");
            System.out.println(this.toString());
            System.out.println("Enter '1' to attack soldier");
            System.out.println("Enter '2' to attack monster");
            int choice = choiceReader.nextInt();
    
            // Check the value of 'choice' and perform actions accordingly
            switch (choice) {
                case 1:
                    if(currentSoldierNumber <= 0)
                    {
                        break;
                    }
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
                    if(currentMonsterNumber <= 0)
                    {
                        break;
                    }
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
            enemiesRemain = checkAndUpdate();
            if (enemiesRemain == 1)
            {
                Random random = new Random();
                if (currentSoldierNumber > 0)
                {
                    System.out.println("~~~~~~~~~~~~");
                    int randomNumber = random.nextInt(currentSoldierNumber);
                    Soldier selectedSoldier = roundSoldierArray[randomNumber];
                    player.health -= selectedSoldier.combat();
                }
                if (currentMonsterNumber > 0)
                {
                    System.out.println("~~~~~~~~~~~~");
                    int randomNumber = random.nextInt(currentMonsterNumber);
                    Monster selectedMonster = roundMonsterArray[randomNumber];
                    player.health -= selectedMonster.combat();
                }
            }
            if (player.health < 0)
            {
                System.out.println("You died!");
                playerAlive = 0;
            }
        }
    }
    
    public int checkAndUpdate()
    {
        if (currentSoldierNumber > 0)
        {
            for (int i = 0; i < currentSoldierNumber; i++)
            {
                if (roundSoldierArray[i] != null)
                {
                    if (roundSoldierArray[i].health <= 0)
                    {
                        System.out.println(roundSoldierArray[i].name + " died");
                        removeSoldier(i);
                    }
                }
                else
                {
                    System.out.println("soldier lost error at " + i);
                    return 1;
                }
            }
        }

        if (currentMonsterNumber > 0)
        {
            for (int i = 0; i < currentMonsterNumber; i++)
            {
                if (roundMonsterArray[i] != null)
                {
                    if (roundMonsterArray[i].health <= 0)
                    {
                        System.out.println(roundMonsterArray[i].name + " died");
                        removeMonster(i);
                    }
                }
                else
                {
                    System.out.println("monster lost error at " + i);
                    return 1;
                }
            }
        }
        if ((currentMonsterNumber + currentSoldierNumber) == 0)
        {
            return 0;
        }
        return 1;
    }

    public void removeSoldier(int toRemove)
    {
        Soldier[] tmpRoundSoldierArray = roundSoldierArray;
        int tmpSoldierNumber = currentSoldierNumber;
        //System.out.println("target to remove " + tmpRoundSoldierArray[toRemove]);
        this.roundSoldierArray = new Soldier [1000];
        this.currentSoldierNumber = 0;
        for (int i = 0; (i < tmpSoldierNumber); i++)
        {
            //System.out.println("adding: " + tmpRoundSoldierArray[i]);
            if(i != toRemove)
            {
                appendSoldier(tmpRoundSoldierArray[i]);
            }
        }
    }

    public void removeMonster(int toRemove)
    {
        Monster[] tmpRoundMonsterArray = roundMonsterArray;
        int tmpMonsterNumber = currentMonsterNumber;
        //System.out.println("target to remove " + tmpRoundMonsterArray[toRemove]);
        this.roundMonsterArray = new Monster [1000];
        this.currentMonsterNumber = 0;
        for (int i = 0; (i < tmpMonsterNumber); i++)
        {
            //System.out.println("adding: " + tmpRoundMonsterArray[i]);
            if(i != toRemove)
            {
                appendMonster(tmpRoundMonsterArray[i]);
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
