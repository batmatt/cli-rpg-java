package src.com.clirpg.game;

import java.util.Scanner;

public class Gameplay {
    private boolean gameOver;

    public Gameplay() {
    }

    public void openGameWorld() {
        gameOver = false;
        System.out.println("\nYou find yourself in a vast game world.");
        while (!gameOver) {
            displayExplorationMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println("You chose to explore option 1.");
                    // eg. moves to arena
                    break;
                case 2:
                    System.out.println("You chose to explore option 2.");
                    break;
                case 3:
                    System.out.println("You chose to explore option 3.");
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
        System.out.println("1. Explore option 1");
        System.out.println("2. Explore option 2");
        System.out.println("3. Explore option 3");
        System.out.println("4. Display your character status");
        System.out.println("5. Return to Main Menu");
    }

    private void displayCharacterStatus() {
        System.out.println("\nCharacter Status:");
        System.out.println("Name: ");
        System.out.println("Health: ");
        System.out.println("Attack: ");
        System.out.println("Defense: ");
    }
}
