package src.com.clirpg.characters;

public class Shopkeeper extends Entity implements Talk{
    final static boolean friendly = true;
    String job = "Shopkeeper";

    public Shopkeeper(String name)
    {
        super(name);
        this.health = 100;
    }

    public void talk()
    {
        System.out.println("What would you like to purchase today?");
    }

    public String toString()
    {
        return this.name + " " + this.job; 
    }
}