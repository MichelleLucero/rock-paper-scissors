import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

abstract class Player {
    private int winCount;
    private String playerType;
    private ArrayList<String[]> playerGameHistory;
//    Manage the state of the player

    public Player(String playerType){
        this.playerType = playerType.toLowerCase();
        this.playerGameHistory = new ArrayList<String[]>();
        this.winCount = 0;
    }

//    state if they won or lost
//    state what move they made [history list??]
    public abstract String playerChoice();

    public void addChoiceToHistory(String choice, String result ){
        String[] currentGameHistory = new String[]{choice, result};
        playerGameHistory.add(currentGameHistory);
    }

    public ArrayList<String[]> getHistory(){
        return playerGameHistory;
    }

    public String getPlayerType(){
        return playerType;
    }

    public void incrementWinCount(){
        winCount++;
    }

    public int getWinCount(){
        return winCount;
    }

    public void getHistoryOutput(Player otherPlayer){
        System.out.println("=== GAME HISTORY ===");
        for(int i = 0; i < playerGameHistory.size(); i ++){
            String playerChoice = playerGameHistory.get(i)[0];
            String playerResult = playerGameHistory.get(i)[1];
            String otherPlayerChoice = otherPlayer.getHistory().get(i)[0];
            String line = playerType + " picked " + playerChoice + ", " + otherPlayer.getPlayerType() + " picked " + otherPlayerChoice;
            if(playerResult.equals(playerType)){
                System.out.println("WIN: " + line);
            } else if(playerResult.equals(otherPlayer.getPlayerType())){
                System.out.println("LOSS: " + line);
            } else {
                System.out.println("TIE: " + line);
            }
        }
    }

}
