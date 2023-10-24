package src.com.clirpg.characters;

public class Civillian extends Entity implements Talk{
    final static boolean friendly = true;
    String job;

    public Civillian(String name, String job)
    {
        super(name);
        this.job = job;
        this.health = 100;
    }

    public Civillian(String name, String job, int health)
    {
        super(name, health);
        this.job = job;
    }

    public void talk()
    {
        System.out.println("hi");
    }

    public String toString()
    {
        return this.name + " " + this.job; 
    }
}