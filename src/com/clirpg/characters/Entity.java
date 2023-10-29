package src.com.clirpg.characters;

import java.io.Serializable;

abstract class Entity implements Serializable
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

    public int getHealth()
    {
        return this.health;
    }

    public void setHealth(int change)
    {
        this.health = this.health - change;
    }
}