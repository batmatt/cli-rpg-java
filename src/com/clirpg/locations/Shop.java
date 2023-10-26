package src.com.clirpg.locations;

import java.util.Scanner;
import src.com.clirpg.characters.Shopkeeper;
import src.com.utils.ConsoleColors;

public class Shop implements Visit {
    private Shopkeeper shopkeeper;

    public Shop() {
        shopkeeper = new Shopkeeper("Bob");
    }
    
    public void visit(){

        shopkeeper.talk();

        //printShop();

        Scanner shopScan = new Scanner(System.in); 
        boolean shopBool = true;

        while(shopBool){

            printShop();
            System.out.println("Type in the number of the upgrade you want to have");
            int choiceShop = shopScan.nextInt();

            switch(choiceShop){
                case 1:     /* upgrade attack1 strength +1;*/showStats(choiceShop); break;
                case 2:     /* upgrade attack2 strength +1;*/showStats(choiceShop); break;
                case 3:     /* upgrade attack1 hit probability +5%;*/showStats(choiceShop); break;
                case 4:     /* upgrade attack2 hit probability +5%;*/showStats(choiceShop); break;
                case 5:     shopBool = false; break;
                default:    System.out.println("Invalid choice. Please try again.");
            }
        }   

        shopkeeper.talkEnd();
    }

    private void printShop(){

            System.out.println(ConsoleColors.CYAN + "\n" + shopkeeper.toString() + ": Here are the options you can choose:" + ConsoleColors.RESET);
            System.out.println("1. Attack1 strength +1, costs xx");
            System.out.println("2. Attack2 strength +1, costs xx");
            System.out.println("3. Attack1 hit probability +5%, costs xx");
            System.out.println("4. Attack2 hit probability +5%, costs xx");
            System.out.println("5. Exit"); 
            return;
        }

    private void showStats(int choiceShop){
        System.out.println("\nYou chose option " + choiceShop);
        System.out.println("Your new stats are:"); // add print stats in player
    }

    
}
