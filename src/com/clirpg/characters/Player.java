package src.com.clirpg.characters;

import java.util.Random;


public class Player extends Entity implements Combat {
    public int attackStrength;
    public int hitProbability;
    public int money;
    public int maxLevelArena;

    final boolean friendly = true;
    
    public Player(String name, CharacterClass characterClass)
    {
        super(name);
        money = 100;
        maxLevelArena = 0;
        this.health = characterClass.health;
        this.attackStrength = characterClass.attackStrength;
        this.hitProbability = characterClass.hitProbability;   
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Health: " + health + ", Attack Strength: " + attackStrength + ", Hit Probability: " + hitProbability + ", Money: " + money;
    }

    public int combat()
    {
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(100);
        //System.out.println("rng: " + randomNumber);
        if(randomNumber < this.hitProbability)
        {
            System.out.println("Attack hits for " + this.attackStrength + " damage");
            return this.attackStrength;
        }
        else
        {
            System.out.println("Attack fails");
        }
        return 0;
    }
}
