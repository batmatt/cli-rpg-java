package src.com.clirpg.characters;

public class Monster extends Entity implements Combat{
    final static boolean friendly = false;
    String job = "Monster";
    
    public Monster(String name)
    {
        super(name);
        this.health = 30;
    }

    public Monster(String name, int health)
    {
        super(name, health);
    }

    public int combat()
    {
        System.out.println("start combat");
        return 1;
    }

    public String toString()
    {
        return this.name + " HP: " + this.health; 
    }
}