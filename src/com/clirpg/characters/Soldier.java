package src.com.clirpg.characters;

public class Soldier extends Entity implements Combat, Talk{
    final static boolean friendly = false;
    String job = "Enemy Soldier";
    
    public Soldier(String name)
    {
        super(name);
        this.health = 15;
    }

    public Soldier(String name, int health)
    {
        super(name, health);
    }

    public int combat()
    {
        System.out.println("start combat");
        return 1;
    }

    public void talk()
    {
        System.out.println("Surrender now or else!!");
    }

    public String toString()
    {
        return this.name + " HP: " + this.health; 
    }
}