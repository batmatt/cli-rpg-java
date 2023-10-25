package src.com.clirpg.characters;

public enum CharacterClass {
    WARRIOR(100, 20, 10),
    MAGE(80, 30, 5),
    ROGUE(90, 25, 15);

    int health;
    int attack;
    int defense;

    CharacterClass(int health, int attack, int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }
}