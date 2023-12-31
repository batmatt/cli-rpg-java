package src.com.clirpg.game;

import src.com.clirpg.characters.Player;
import src.com.clirpg.locations.*;
import src.com.utils.ConsoleColors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Gameplay {
    private Player player;
    public void setPlayer(Player player) {
        this.player = player;
    }

    private Arena arena;
    private Shop shop;
    private Village village;
    private boolean gameOngoing;
    private Quest quest;

    public Gameplay() {
        arena = new Arena();
        shop = new Shop();
        quest = new Quest();
        village = new Village(quest);  
    }

    public void openGameWorld(Player player) {
        gameOngoing = true;
        quest.setPlayer(player);
        System.out.println("\nYou find yourself in a vast game world.");

        while (gameOngoing) {
            displayExplorationMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    arena.setPlayer(player);
                    arena.visit();
                    break;
                case 2:
                    shop.setPlayer(player);
                    shop.visit();
                    break;
                case 3:
                    village.setPlayer(player);
                    village.visit();
                    break;
                case 4:
                    displayCharacterStatus();
                    break;
                case 5:
                    System.out.println(ConsoleColors.RED + "Returning to the main menu." + ConsoleColors.RESET);
                    gameOngoing = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Please try again." + ConsoleColors.RESET);
            }
        }
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your choice: ");
            return scanner.nextInt(); 
        } catch (InputMismatchException e) {
            return 0; // put 0 value to trigger default switch case
        }
    }

    private void displayExplorationMenu() {
        System.out.println("\nWhat are you going to do?");
        System.out.println("1. Visit Arena");
        System.out.println("2. Go to the Shop");
        System.out.println("3. Explore nearby Village");
        System.out.println("4. Display your character status");
        System.out.println("5. Return to Main Menu");
    }

    private void displayCharacterStatus() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "\nCharacter Status:" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "Name: " + player.name + ConsoleColors.RESET) ;
        System.out.println(ConsoleColors.BLUE + "Health: " + player.health + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "Attack strength: " + player.attackStrength + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "Hit rate: " + player.hitProbability + ConsoleColors.RESET);
    }
}
