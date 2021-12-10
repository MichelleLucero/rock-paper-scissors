import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(){
        super("computer");
    }

    private String[] choices = {"rock", "paper", "scissors"};
    @Override
    public String playerChoice() {
        Random random = new Random();
        int index = random.nextInt(3);
        System.out.println(choices[index]);
        return choices[index];
    }


}
