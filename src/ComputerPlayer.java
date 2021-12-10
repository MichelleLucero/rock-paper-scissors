import java.util.Random;

public class ComputerPlayer extends Player {
    private String[] choices = {"rock", "paper", "scissors"};
    @Override
    public String playerChoice() {
        Random random = new Random();
        int index = random.nextInt(3);
        System.out.println(index);
        return choices[index];
    }
}
