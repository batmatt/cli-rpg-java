package src.com.clirpg.characters;

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
        return "Player [health=" + health + ", attackStrength=" + attackStrength + ", hitProbability=" + hitProbability + ", money=" + money
                + "]";
    }

    public void combat()
    {
        System.out.println("start combat");
    }
}
