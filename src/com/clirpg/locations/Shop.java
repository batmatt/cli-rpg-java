package src.com.clirpg.locations;

import java.util.InputMismatchException;
import java.util.Scanner;

import src.com.clirpg.characters.*;
import src.com.utils.ConsoleColors;

public class Shop implements Visit {
    private Shopkeeper shopkeeper;
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Shop() {
        shopkeeper = new Shopkeeper("Jack");
    }

    public void visit() {

        shopkeeper.talk();

        // printShop();

        Scanner shopScan = new Scanner(System.in);
        boolean shopBool = true;

        while (shopBool) {

            printShop();
            System.out.println("Money: " + player.money);
            System.out.println("Type in the number of the upgrade you want to have");
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    if(player.money >= 10){
                        player.attackStrength += 1;
                        player.money -= 10;
                        System.out.println("Your current attack strength: " + player.attackStrength);
                    }else{
                        System.out.println(ConsoleColors.CYAN + "\n" + shopkeeper.toString() + ": I am sorry, but you don't have enough money to buy this."
                        + ConsoleColors.RESET);
                    }
                    break;
                case 2:
                    if(player.money >= 10){
                        player.hitProbability += 5;
                        player.money -= 15;
                        System.out.println("Your current hit rate: " + player.hitProbability);
                    }else{
                        System.out.println(ConsoleColors.CYAN + "\n" + shopkeeper.toString() + ": I am sorry, but you don't have enough money to buy this."
                        + ConsoleColors.RESET);
                    }
                    break;
                case 3:
                    if(player.money >= 20){
                        player.health += 5;
                        player.money -= 20;
                        System.out.println("Your current health: " + player.health);
                    }else{
                        System.out.println(ConsoleColors.CYAN + "\n" + shopkeeper.toString() + ": I am sorry, but you don't have enough money to buy this."
                        + ConsoleColors.RESET);
                    }
                    break;
                case 4:
                    shopBool = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Please try again." + ConsoleColors.RESET);
            }

            shopkeeper.talkThanks();
        }

        shopkeeper.talkEnd();
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

    private void printShop() {
        System.out.println(ConsoleColors.CYAN + "\n" + shopkeeper.toString() + ": Here are the options you can choose:"
                + ConsoleColors.RESET);
        System.out.println("1. Attack1 strength +1, costs 10");
        System.out.println("2. Attack1 hit probability +5%, costs 15");
        System.out.println("3. Health +5, costs 20");
        System.out.println("4. Exit");
        return;
    }

}
