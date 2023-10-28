package src.com.clirpg.game;

import src.com.clirpg.characters.Player;
import src.com.clirpg.locations.*;
import java.util.Scanner;

public class Gameplay {
    private Player player;
    public void setPlayer(Player player) {
        this.player = player;
    }

    private Arena arena;
    private Shop shop;
    private Village village;
    private boolean gameOver;
    private Quest quest;

    public Gameplay() {
        arena = new Arena();
        shop = new Shop();
        quest = new Quest();
        village = new Village(quest);  
    }

    public void openGameWorld(Player player) {
        quest.setPlayer(player);
        gameOver = false;
        System.out.println("\nYou find yourself in a vast game world.");
        while (!gameOver) {
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
                    System.out.println("Returning to the main menu.");
                    gameOver = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
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
        System.out.println("\nCharacter Status:");
        System.out.println("Name: " + player.name);
        System.out.println("Health: " + player.health);
        System.out.println("Attack strength: " + player.attackStrength);
        System.out.println("Hit rate: " + player.hitProbability);
    }
}
