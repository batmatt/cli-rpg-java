package src.com.clirpg.locations;

import java.util.InputMismatchException;
import java.util.Scanner;

import src.com.clirpg.game.Round;
import src.com.clirpg.characters.Civillian;
import src.com.clirpg.characters.Player;
import src.com.utils.ConsoleColors;

public class Arena implements Visit{
    
    private Civillian trainer;
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Arena() {
        trainer = new Civillian("Bertrand", "Trainer");
    }
    
    public void visit(){

        System.out.println("\n");
        System.out.println(ConsoleColors.PURPLE_BOLD + trainer.toString() + ": Welcome to the arena!" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.PURPLE + trainer.toString() + ": At what level do you want to start?" + ConsoleColors.RESET);

        int levelArena = getUserChoice();

        // start fight with power level: levelArena

        Round round1 = new Round(levelArena, player);
        if (round1.startRound() == 0)
        {
            return;
        };

        String contFight = "y";
        Scanner contScan = new Scanner(System.in);
        while(contFight.equals("y")){
            System.out.println("\n" + ConsoleColors.PURPLE + trainer.toString() + ": Good fight! Do you want to continue fighting?" + ConsoleColors.RESET);
            System.out.println("If yes type y otherwise n");
            contFight = contScan.nextLine();

            switch(contFight){
                case "y":   levelArena++; 
                            System.out.println(ConsoleColors.PURPLE + trainer.toString() + ": The fight continues with the arena level " + levelArena + ConsoleColors.RESET); 
                            round1 = new Round(levelArena, player);
                            if (round1.startRound() == 0)
                            {
                                return;
                            };
                            break;
                case "n":   contFight = "n"; 
                            System.out.println(ConsoleColors.PURPLE_BOLD + trainer.toString() + ": This was a nice fighting session. I look forward to seeing you in the arena again." + ConsoleColors.RESET);
                            if(levelArena > player.maxLevelArena){
                                player.maxLevelArena = levelArena;
                            }
                            break;
                default:    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "This is not a valid option. Try again." + ConsoleColors.RESET); 
                            contFight = "y";
            }

        }
        return;
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your choice: ");
            return scanner.nextInt(); 
        } catch (InputMismatchException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "This is not a valid option. Starting at level 0." + ConsoleColors.RESET);
            return 0; // put 0 value to trigger default switch case
        }
    }
}
