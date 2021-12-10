import java.util.Locale;
import java.util.Scanner;

public class Game {
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
    }

    public static String mainMenuChoice() {
        mainMenu();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean isValidOption = false;
        while(!isValidOption){
            input = scanner.nextLine().toLowerCase();
            if(input.equals("play") || input.equals("history") || input.equals("quit")){
                isValidOption = true;
            } else {
                System.out.println("Invalid Choice. Pick play, history, or quit.");
            }
        }
        return input;
    }

    public static String historyChoice(Player player1, Player player2) {
        System.out.println("Whose history?");
        System.out.println("Type '" + player1.getPlayerType() + "' for " + player1.getPlayerType() + "'s history");
        System.out.println("Type '" + player2.getPlayerType() + "' for " + player2.getPlayerType() + "'s history");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean isValidOption = false;
        while(!isValidOption){
            input = scanner.nextLine().toLowerCase();
            if(input.equals(player1.getPlayerType()) || input.equals(player2.getPlayerType())){
                isValidOption = true;
            } else {
                System.out.println("Invalid Choice. Pick " + player1.getPlayerType() + " or " + player2.getPlayerType());
            }
        }
        return input;
    }

    public static void playMenu(){
        System.out.println("\n\nType 'rock', 'paper', or 'scissors' to play.");
        System.out.println("Type 'quit' to go back to the main menu.");
    }

    public static String chooseWinner(Player player1, Player player2){
        String player1Choice = "";
        String player2Choice = "";
        String result = "Tie";

        System.out.println("\n" + player1.getPlayerType() + "'s turn");
        player1Choice = player1.playerChoice();
        System.out.println("\n" + player2.getPlayerType() + "'s turn");
        player2Choice = player2.playerChoice();

        if( player1Choice.equals("rock") && player2Choice.equals("scissors") ){
            result =  player1.getPlayerType();
            player1.incrementWinCount();
        } else if ( player2Choice.equals("rock") && player1Choice.equals("scissors") ){
            result =  player2.getPlayerType();
            player2.incrementWinCount();
        }

        if ( player1Choice.equals("scissors") && player2Choice.equals("paper") ){
            result = player1.getPlayerType();
            player1.incrementWinCount();
        } else if (player2Choice.equals("scissors") && player1Choice.equals("paper")){
            result =  player2.getPlayerType();
            player2.incrementWinCount();
        }

        if ( player1Choice.equals("paper") && player2Choice.equals("rock") ){
            result =  player1.getPlayerType();
            player1.incrementWinCount();
        } else if (player2Choice.equals("paper") && player1Choice.equals("rock") ){
            result = player2.getPlayerType();
            player2.incrementWinCount();
        }

        // Adding contents to both player's history
        player1.addChoiceToHistory(player1Choice, result);
        player2.addChoiceToHistory(player2Choice, result);

        // Announcing game outcome
        if(!result.equals("Tie")){
            System.out.println("\n" + result + " won!");
        } else{
            System.out.println("\nIt's a tie!");
        }

        return result;
    }

//  Call this when game is over to announce official winner
    public static void overallWinner(Player player1, Player player2){
        if(player1.getWinCount() > player2.getWinCount()){
            System.out.println("\n"+ player1.getPlayerType() + " won overall!!!");
        } else if( player2.getWinCount() > player1.getWinCount()){
            System.out.println("\n"+ player2.getPlayerType() + " won overall!!!");
        } else {
            System.out.println("\nOverall it's a tie!!!");
        }
    }
// player2 will be either ComputerPlayer or HumanPlayer
    public static void playGame(Player player1, Player player2) {
        boolean isGameInProgress = true;
        while(isGameInProgress){
            String menuChoice = mainMenuChoice();
            if(menuChoice.equals("play")){
                playMenu();
                chooseWinner(player1, player2);

            } else if(menuChoice.equals("history")){
                String playerHistoryChoice = historyChoice(player1, player2);

                if(playerHistoryChoice.equals(player1.getPlayerType())){
                    player1.getHistoryOutput(player2);
                } else{
                    player2.getHistoryOutput(player1);
                }

            } else {
                overallWinner(player1, player2);
                System.out.println("\n===ENDED GAME===");
                isGameInProgress = false;
            }
        }
    }

//  who types history player?? should I ask for clarification of whose history;
    public static void main(String[] args) {
        String gameModeChoice = gameMode();
        HumanPlayer player1 = new HumanPlayer("suresh");
        if (gameModeChoice.equals("2 players")){
            HumanPlayer player2 = new HumanPlayer("david");
            playGame(player1, player2);
        } else {
            ComputerPlayer player2 = new ComputerPlayer();
            playGame(player1, player2);
        }
    }

}
