import java.util.Locale;
import java.util.Scanner;

public class Game {
    private static String gameModeOption1 = "2 players";
    private static String gameModeOption2 = "vs. computer";
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

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

    public static String playerMenuChoice() {
        mainMenu();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean isValidOption = false;
        while(!isValidOption){
            input = scanner.nextLine();
            if(input.equals("play") || input.equals("history") || input.equals("quit")){
                isValidOption = true;
            } else {
                System.out.println("Invalid Choice. Pick play, history, or quit.");
            }
        }
        return input;
    }

    public String chooseWinner(String player1Choice, String player2Choice){

        if( player1Choice.equals("rock") && player2Choice.equals("scissors") ){
            return "player1";
        } else if ( player2Choice.equals("rock") && player1Choice.equals("scissors") ){
            return "player2";
        }

        if ( player1Choice.equals("scissors") && player2Choice.equals("paper") ){
            return "player1";
        } else if (player2Choice.equals("scissors") && player1Choice.equals("paper")){
            return "player2";
        }

        if ( player1Choice.equals("paper") && player2Choice.equals("rock") ){
            return "player1";
        } else if (player2Choice.equals("paper") && player1Choice.equals("rock") ){
            return "player2";
        }

        return "tie";
    }

    public static void playGame(Player player1, Player player2){
        System.out.println("Hello");
        boolean isGameInProgress = true;
        while(isGameInProgress){
            String menuChoice = playerMenuChoice();

            System.out.println(menuChoice);
        }
    }

    public static void main(String[] args) {
        String gameModeChoice = gameMode();
        HumanPlayer player1 = new HumanPlayer();
        if (gameModeChoice.equals("2 players")){
            HumanPlayer player2 = new HumanPlayer();
            playGame(player1, player2);
        } else {
            ComputerPlayer player2 = new ComputerPlayer();
            playGame(player1, player2);
        }

    }

}
