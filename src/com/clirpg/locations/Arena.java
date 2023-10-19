import java.util.Scanner;

class Arena implements Visit{
    
    public void visit(){

        System.out.println("Welcome to the arena!");

        Scanner lvlScan = new Scanner(System.in);
        System.out.println("At what level do you want to start?");

        int levelArena = lvlScan.nextInt();

        // start fight with power level: levelArena

        String contFight = "y";
        Scanner contScan = new Scanner(System.in);
        while(contFight.equals("y")){
            System.out.println("Do you want to continue fighting?");
            System.out.println("If yes type y otherwise n");
            contFight = contScan.nextLine();

            switch(contFight){
                case "y":   levelArena++; 
                            System.out.println("The fight continues with the arena level " + levelArena); 
                            /*  start fight with power level: levelArena;*/ break;
                case "n":   contFight = "n"; break;
                default:    System.out.println("This is not a valid option. Try again."); 
                            contFight = "y";
            }

        }

        return;

    }
}
