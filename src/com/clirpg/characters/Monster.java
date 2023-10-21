class Monster extends Entity implements Combat{
    final static boolean friendly = false;
    String job = "Monster";
    
    Monster(String name)
    {
        super(name);
        this.health = 100;
    }

    Monster(String name, int health)
    {
        super(name, health);
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