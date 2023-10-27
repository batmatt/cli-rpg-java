package src.com.clirpg.characters;

public class Player extends Entity implements Combat{
    public int attackStrength;
    public int hitProbability;
    public int money;

    final static boolean friendly = true;
    String job = "Warrior";
    
    public Player(String name, CharacterClass characterClass)
    {
        super(name);
        money = 100;
        this.health = characterClass.health;
        this.attackStrength = characterClass.attackStrength;
        this.hitProbability = characterClass.hitProbability;   
    }

    public void combat()
    {
        System.out.println("start combat");
    }

    public String toString()
    {
        return this.name + " " + this.job; 
    }
}