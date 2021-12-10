import java.util.Locale;
import java.util.Scanner;

public class HumanPlayer extends Player{
    //    error handle later
    @Override
    public String playerChoice() {
        boolean isValidOption = false;
        String input = "";
        while(!isValidOption){
            input = playerInput();
            if(input.equals("rock") || input.equals("paper") || input.equals("scissors")){
                isValidOption = true;
            } else {
                System.out.println("Invalid Choice. Pick play, history, or quit.");
            }
        }
        return input;
    }


    public String playerInput() {
        Scanner scanner = new Scanner(System.in);
        String playerChoice = scanner.nextLine();
        return playerChoice.toLowerCase();
    }
}
