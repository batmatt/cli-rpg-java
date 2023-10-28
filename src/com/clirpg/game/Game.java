package src.com.clirpg.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        System.out.println(ConsoleColors.GREEN_BACKGROUND + "Welcome to the Text RPG Game!" + ConsoleColors.RESET);
        
        closeGame = false;
        while (!closeGame) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    if (player == null) {
                        player = loadCharacter();
                        if (player == null) {
                            startNewGame();
                        }
                        System.out.println("Game started with character: " + player.name);
                        gameplay.openGameWorld(player);
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "You have an active game" + ConsoleColors.RESET);
                        gameplay.openGameWorld(player);
                    }
                    break;
                case 2:
                    if (player != null) {
                        saveCharacter(player);
                        System.out.println("Character progress saved.");
                        player = loadCharacter();
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "No character to save. Create a character first." + ConsoleColors.RESET);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    closeGame = true;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Please try again." + ConsoleColors.RESET);
            }
        }
    }

     private void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Start Game");
        System.out.println("2. Save Game"); 
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

    private Player loadCharacter() {
        File characterFile = new File("savedCharacter.dat");

        if (characterFile.isFile()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(characterFile))) {
                return (Player) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    private void saveCharacter(Player player) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savedCharacter.dat"))) {
            oos.writeObject(player);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}