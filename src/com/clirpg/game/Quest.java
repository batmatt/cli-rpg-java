package src.com.clirpg.game;

import src.com.clirpg.characters.Civillian;
import src.com.clirpg.characters.Player;
import src.com.utils.ConsoleColors;

public class Quest {

    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
        if(healthQuest < 60 ){
            healthQuest = player.health + 20;
        }
        if(strengthQuest < 10){
            strengthQuest = player.attackStrength + 10;
        }
    }

    private int levelArenaQuest;
    private int healthQuest;
    private int strengthQuest;
    private Civillian mayor;

    public Quest() {
        levelArenaQuest = 5;
        healthQuest = 0;
        strengthQuest = 0;
        mayor = new Civillian("Thomas", "Mayor");

    }
    
    public void showQuests(){

        checkQuests();
        printQuests();
        System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": Come back the next time you have finished one of those quests\n" + ConsoleColors.RESET);
        

    }

    private void printQuests(){
        System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": These are your general quests:" + ConsoleColors.RESET);
        System.out.println("\nGet to arena level " + levelArenaQuest);
        System.out.println("\nUpgrade your health to " + healthQuest);
        System.out.println("\nUpgrade your attack strength to " + strengthQuest);
        System.out.println("\nYou get 20 Coins for achieveing a quest.");
        System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": After you have finished a quest, you can return and collect your reward." + ConsoleColors.RESET);
    }

    private void checkQuests(){

        if(player.maxLevelArena >= levelArenaQuest){
            System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": Congratulations! You completed the quest to achieve arena level " + levelArenaQuest + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + mayor.toString() + ": Here is your money!" + ConsoleColors.RESET);
            player.money += 20;
            System.out.println("Money: " + player.money);
            levelArenaQuest += 5;
            System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": Your next arena level to achieve is " + levelArenaQuest + ConsoleColors.RESET);
        }
        if(player.health >= healthQuest){
            System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": Congratulations! You completed the quest to upgrade your health " + healthQuest + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + mayor.toString() + ": Here is your money: " + ConsoleColors.RESET);
            player.money += 20;
            System.out.println("Money: " + player.money);
            healthQuest += 20;
            System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": Your next required health for this task is " + healthQuest + ConsoleColors.RESET);
        }
        if(player.attackStrength >= strengthQuest){
            System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": Congratulations! You completed the quest to upgrade your attack strength " + strengthQuest + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + mayor.toString() + ": Here is your money: " + ConsoleColors.RESET);
            player.money += 20;
            System.out.println("Money: " + player.money);
            strengthQuest += 20;
            System.out.println(ConsoleColors.GREEN + "\n" + mayor.toString() + ": Your next required attack strength for this task  " + strengthQuest + ConsoleColors.RESET);
        }


    }
}
