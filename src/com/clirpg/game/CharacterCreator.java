package src.com.clirpg.game;

import java.util.Scanner;
import src.com.clirpg.characters.CharacterClass;
import src.com.clirpg.characters.Player;

public class CharacterCreator {

   public Player createCharacter() {
        System.out.println("Character Creation:");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();

        CharacterClass characterClass = chooseCharacterClass();
        Player player = new Player(playerName, characterClass);

        System.out.println("You have created a " + characterClass + " named " + playerName + " with the following statistics:");
        System.out.println("Health: " + player.health);
        System.out.println("Attack: " + player.attack);
        System.out.println("Defense: " + player.defense);

        return player;
    }

    private CharacterClass chooseCharacterClass() {
        System.out.println("Choose your character class:");
        for (CharacterClass characterClass : CharacterClass.values()) {
            System.out.println(characterClass.ordinal() + 1 + ". " + characterClass);
        }

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.print("Enter the number of your chosen class: ");
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= CharacterClass.values().length) {
                    return CharacterClass.values()[choice - 1];
                } else {
                    System.out.println("Invalid choice. Please enter a valid class number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); 
            }
        }
    }
}
