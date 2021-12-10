import java.io.Console;
import java.util.Locale;
import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(String playerType){
        super(playerType);
    }

    //    error handle later
    @Override
    public String playerChoice() {
        boolean isValidOption = false;
        String input = "";
        while(!isValidOption){
            input = playerInput().toLowerCase();
            if(input.equals("rock") || input.equals("paper") || input.equals("scissors") || input.equals("quit")){
                isValidOption = true;
            } else {
                System.out.println("Invalid Choice. Pick rock, paper, or scissors.");
            }
        }
        return input;
    }


    public String playerInput(){
        String playerChoice = "";
        Scanner scanner = new Scanner(System.in);
        playerChoice = scanner.nextLine();

        return playerChoice.toLowerCase();
    }
}
