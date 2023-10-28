package src.com.clirpg.characters;

import java.io.Serializable;

public class Player extends Entity implements Combat, Serializable{
    public int attackStrength;
    public int hitProbability;
    public int money;

    final static boolean friendly = true;
    
    public Player(String name, CharacterClass characterClass)
    {
        super(name);
        money = 100;
        this.health = characterClass.health;
        this.attackStrength = characterClass.attackStrength;
        this.hitProbability = characterClass.hitProbability;   
    }

    @Override
    public String toString() {
        return "Player [health=" + health + ", attackStrength=" + attackStrength + ", hitProbability=" + hitProbability + ", money=" + money
                + "]";
    }

    public void combat()
    {
        System.out.println("start combat");
    }
}