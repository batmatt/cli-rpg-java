package src.com.clirpg.characters;

import src.com.utils.ConsoleColors;

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
        //System.out.println(ConsoleColors.GREEN + "\n" + toString() + ": " + player.toName() + ", I need your help. I saw a monster at xxx with level xxx. Do you want to fight it? You would get 10 coins for it\n" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "\n" + toString() + ": I saw a monster at xxx with level xxx. Do you want to fight it? You would get 10 coins for it\n" + ConsoleColors.RESET);
    }

    public String toString()
    {
        return this.job + " " + this.name; 
    }

    public void talkEnd()
    {
        System.out.println(ConsoleColors.GREEN + "\n" + toString() + ": Thank you for killing the monster. Here is your reward.\n" + ConsoleColors.RESET);
    }
}
