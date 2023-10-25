package src.com.clirpg.characters;

abstract class Entity
{
    public String name;
    public int health;

    Entity (String name)
    {
        this.name = name;
    }

    Entity (String name, int health)
    {
        this.name = name;
        this.health = health;
    }
}