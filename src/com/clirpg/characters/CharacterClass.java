package src.com.clirpg.characters;

public enum CharacterClass {
    WARRIOR(100, 30, 10),
    MAGE(80, 10, 20),
    ROGUE(60, 15, 30);

    public int health;
    public int attackStrength;
    public int hitProbability;

    CharacterClass(int health, int attackStrength, int hitProbability) {
        this.health = health;
        this.attackStrength = attackStrength;
        this.hitProbability = hitProbability;
    }
}