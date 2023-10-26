package src.com.clirpg.characters;

import src.com.utils.ConsoleColors;

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
        System.out.println(ConsoleColors.CYAN + "\n" + toString() + ": Welcome to the shop! What would you like to purchase today?\n" + ConsoleColors.RESET);
    }

    public String toString()
    {
        return this.job + " " + this.name; 
    }

    public void talkEnd()
    {
        System.out.println(ConsoleColors.CYAN + "\n" + toString() + ": Thanks for your visit. Have a nice journey!" + ConsoleColors.RESET);
    }
}
