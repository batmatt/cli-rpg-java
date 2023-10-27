package src.com.clirpg.locations;

import java.util.Scanner;

import src.com.utils.ConsoleColors;
import src.com.clirpg.characters.Civillian;

public class Village implements Visit {

    private Civillian civillian;

    private Civillian mayor;

    public Village() {
        mayor = new Civillian("Thomas", "Mayor");
    }

    public void visit(){

        civillian = new Civillian(getCivillianName(), getCivillianJob());

        System.out.println(ConsoleColors.GREEN_BOLD + "\n" + mayor.toString() + ": Welcome to the village!" + ConsoleColors.RESET);

        String villageFight = "y";

        while(villageFight.equals("y")){
  
            System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": I have found a civillian who has a quest for you." + ConsoleColors.RESET);
    
            civillian.talk();

            Scanner villageScan = new Scanner(System.in);

            System.out.println("If yes type y otherwise n");
            villageFight = villageScan.nextLine();

            switch(villageFight){
                case "y":   System.out.println("The fight is against xxx"); 
                            /*  start fight ;*/
                            civillian.talkEnd();
                            civillian = new Civillian(getCivillianName(), getCivillianJob());
                            break;
                case "n":   villageFight = "n"; break;
                default:    System.out.println("This is not a valid option. Try again."); 
                            villageFight = "y";
            }
        }

        System.out.println(ConsoleColors.GREEN_BOLD + "\n" + mayor.toString() + ": Thank you for your visit. I hope you come back soon." + ConsoleColors.RESET);
    
    
    }

    private String getCivillianName(){
        String name;

        int random = (int) (Math.random() * 5);

        switch(random){
                case 0:   name = "William"; break;
                case 1:   name = "Arthur"; break;
                case 2:   name = "Lillian"; break;
                case 3:   name = "Alfred"; break;
                case 4:   name = "Audrey"; break;
                case 5:   name = "Edward"; break;
                default:  name = "Edith";
        }

        return name;
    }

    private String getCivillianJob(){
        String job;

        int random = (int) (Math.random() * 5);

        switch(random){
                case 0:   job = "Farmer"; break;
                case 1:   job = "Butcher"; break;
                case 2:   job = "Carpenter"; break;
                case 3:   job = "Baker"; break;
                case 4:   job = "Farmer"; break;
                case 5:   job = "Weaver"; break;
                default:  job = "Armourer";
        }

        return job;
    }
}
