package src.com.clirpg.characters;

public enum CharacterClass {
    WARRIOR(100, 30, 70),
    MAGE(80, 10, 80),
    ROGUE(60, 15, 90);

    public int health;
    public int attackStrength;
    public int hitProbability;

    CharacterClass(int health, int attackStrength, int hitProbability) {
        this.health = health;
        this.attackStrength = attackStrength;
        this.hitProbability = hitProbability;
    }
}