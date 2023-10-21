abstract class Entity
{
    String name;
    int health;

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