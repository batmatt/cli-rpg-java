package src.com.clirpg.locations;

import java.util.Scanner;

public class Village implements Visit {

    public void visit(){

        System.out.println("Welcome to the village!");

        String villageFight = "y";

        while(villageFight.equals("y")){
            System.out.println("We have found a civillian who has a quest for you"); 
    
            System.out.println("I saw a monster at xxx with level xxx. Do you want to fight it? You would get xxx for it");// maybe put name and job of civi there
    
            Scanner villageScan = new Scanner(System.in);

            System.out.println("If yes type y otherwise n");
            villageFight = villageScan.nextLine();

            switch(villageFight){
                case "y":   System.out.println("The fight is against xxx"); 
                            /*  start fight ;*/ break;
                case "n":   villageFight = "n"; break;
                default:    System.out.println("This is not a valid option. Try again."); 
                            villageFight = "y";
            }
        }
    
    
    }
}
