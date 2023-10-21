class Player extends Entity implements Combat{
    final static boolean friendly = true;
    String job = "Warrior";
    
    Player(String name)
    {
        super(name);
        this.health = 100;
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