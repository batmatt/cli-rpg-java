package src.com.clirpg.game;

import java.util.Scanner;
import src.com.clirpg.characters.Player;
import src.com.utils.ConsoleColors;

public class Game {
    private Player player;
    private CharacterCreator characterCreator;
    private Gameplay gameplay;
    private boolean closeGame;

    public Game() {
        gameplay = new Gameplay();
        characterCreator = new CharacterCreator();
    }

    public void start() {
        System.out.println(ConsoleColors.RED + "Welcome to the Text RPG Game!" + ConsoleColors.RESET);
        
        closeGame = false;
        while (!closeGame) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    startNewGame();
                    break;
                //case 2:
                //    loadGame();
                //    break;
                case 3:
                    System.out.println("Goodbye!");
                    closeGame = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

     private void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. New Game");
        System.out.println("2. Load Game"); // we can save our progress like stats/equipment to some file that we can read later
        System.out.println("3. Quit");
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    private void startNewGame() {
        player = characterCreator.createCharacter();
        gameplay.setPlayer(player);
        gameplay.openGameWorld(player);
    }

    private void handleRandomEvent() {
        // random events during exploration?
    }
}