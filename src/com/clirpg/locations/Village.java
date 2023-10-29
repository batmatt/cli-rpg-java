package src.com.clirpg.locations;

import java.util.Scanner;
import java.util.Random;

import src.com.utils.ConsoleColors;
import src.com.clirpg.characters.*;
import src.com.clirpg.game.Quest;
import src.com.clirpg.game.Round;

public class Village implements Visit {

    private Civillian civillian;
    private Civillian mayor;
    private Quest quest;
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }


    public Village(Quest quest) {
        mayor = new Civillian("Thomas", "Mayor");
        this.quest = quest;
            
    }

    
    public void visit(){

        System.out.println(ConsoleColors.GREEN_BOLD + "\n" + mayor.toString() + ": Welcome to the village!" + ConsoleColors.RESET);

        boolean villageBool = true;
        Scanner villageScan = new Scanner(System.in);

        while(villageBool == true){

            printMayor();
            System.out.println("Type in the number you want to have");
            int choiceVillage = villageScan.nextInt();

            switch (choiceVillage) {
                case 1:
                    quest.showQuests();
                    break;
                case 2:
                    fightingQuest();
                    break;
                case 3:
                    villageBool = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
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

    private void fightingQuest(){

        civillian = new Civillian(getCivillianName(), getCivillianJob());
        String villageFight = "y";

        while(villageFight.equals("y")){
  
            System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": I have found a civillian who has a fighting quest for you." + ConsoleColors.RESET);
    
            civillian.talk();

            Scanner villageScan = new Scanner(System.in);

            System.out.println("If yes type y otherwise n");
            villageFight = villageScan.nextLine();

            switch(villageFight){
                case "y":   System.out.println("The fight starts"); 
                            Round round1 = new Round(getEnemyLevel(), player);
                            if (round1.startRound() == 0)
                            {
                                return;
                            };
                            player.money += 10;
                            civillian.talkEnd();
                            System.out.println("Money: " + player.money);
                            civillian = new Civillian(getCivillianName(), getCivillianJob());
                            break;
                case "n":   villageFight = "n"; break;
                default:    System.out.println("This is not a valid option. Try again."); 
                            villageFight = "y";
            }
        }

    }

    private void printMayor(){
        System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": I have general quest and fighting quests for you in this village." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": Here are the options you can choose:" + ConsoleColors.RESET);
        System.out.println("1. General quests");
        System.out.println("2. Fighting quest");
        System.out.println("3. Exit");        
    }

    private int getEnemyLevel(){
        Random random = new Random();
        if(player.maxLevelArena < 3){
            return 1;
        }
        else if(player.maxLevelArena < 5){
            int randomNumber = random.nextInt(2);
            return player.maxLevelArena - randomNumber;
        }
        else{
            int randomNumber = random.nextInt(5);
            return player.maxLevelArena - randomNumber;
        }
    }
}
