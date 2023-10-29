package src.com.clirpg.game;

import java.util.Scanner;
import src.com.clirpg.characters.CharacterClass;
import src.com.clirpg.characters.Player;
import src.com.utils.ConsoleColors;

public class CharacterCreator {

   public Player createCharacter() {
        System.out.println("Character Creation:");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();

        CharacterClass characterClass = chooseCharacterClass();
        Player player = new Player(playerName, characterClass);

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "You have created a " + characterClass + " named " + playerName + ConsoleColors.RESET);

        return player;
    }

    private CharacterClass chooseCharacterClass() {
        System.out.println("Choose your character class:");

        for (CharacterClass characterClass : CharacterClass.values()) {
            var optionNumber = characterClass.ordinal() + 1;
            System.out.println (ConsoleColors.GREEN_BACKGROUND + optionNumber+ ". " + characterClass + ConsoleColors.RESET);
            System.out.println("   Health: " + characterClass.health);
            System.out.println("   Attack strength: " + characterClass.attackStrength);
            System.out.println("   Hit rate: " + characterClass.hitProbability);
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
