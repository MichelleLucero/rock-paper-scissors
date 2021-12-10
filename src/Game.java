import java.util.Locale;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        playGame();
    }

    private static String gameModeOption1 = "2 players";
    private static String gameModeOption2 = "vs. computer";

    public static String gameMode(){
        Scanner scanner = new Scanner(System.in);
        String userModeOption = "";
        boolean isValidOption = false;

        System.out.println("\nWelcome to Rock, Paper, Scissors!");
        System.out.println("Type '" + gameModeOption1 + "' to play against your friend.");
        System.out.println("Type '" + gameModeOption2 + "' to play against a computer.");

//        Error checking for invalid inputs
        while(!isValidOption){
            userModeOption = scanner.nextLine().toLowerCase();
            if(userModeOption.equals(gameModeOption1) || userModeOption.equals(gameModeOption2)){
                isValidOption = true;
            } else {
                System.out.println("Invalid Choice. Pick " + gameModeOption1 + " or " + gameModeOption2);
            }
        }

        return userModeOption;
    }

    public static void mainMenu(){
        System.out.println("\nMAIN MENU \n====");
        System.out.println("1. Type 'play' to play.");
        System.out.println("2. Type 'history' to view your game history.");
        System.out.println("3. Type 'quit' to stop playing.");
//        System.out.println("\nplay");
//        System.out.println("\n\nType 'rock', 'paper', or 'scissors' to play.");
//        System.out.println("Type 'quit' to go back to the main menu.");
    }
    public static void playGame(){
        String gameModeOption = gameMode();
        System.out.println(gameModeOption);
//        Scanner scanner = new Scanner(System.in);
//        String userInput = "";
//        boolean isGameInProgress = true;
//
//
//
//        while (isGameInProgress){
//            mainMenu();
//            userInput = scanner.nextLine();
//        }
    }



}
