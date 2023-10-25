package src.com.clirpg.characters;

public class Player extends Entity implements Combat{
    public int attack;
    public int defense;

    final static boolean friendly = true;
    String job = "Warrior";
    
    public Player(String name, CharacterClass characterClass)
    {
        super(name);
        this.health = characterClass.health;
        this.attack = characterClass.attack;
        this.defense = characterClass.defense;   
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