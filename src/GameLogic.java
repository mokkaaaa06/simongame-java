
import java.util.*;

public class GameLogic {

    private List<Integer> pattern = new ArrayList<>();
    private List<Integer> player = new ArrayList<>();
    private Random random = new Random();
    private int score = 0;

    public void nextRound() {
        player.clear();
        pattern.add(random.nextInt(4));
    }

    public boolean checkInput(int input) {
        player.add(input);
        int index = player.size() - 1;

        if(!player.get(index).equals(pattern.get(index))) {
            return false;
        }

        if(player.size() == pattern.size()) {
            score++;
        }
        return true;
    }

    public boolean roundComplete() {
        return player.size() == pattern.size();
    }

    public List<Integer> getPattern() {
        return pattern;
    }

    public int getScore() {
        return score;
    }

    public void reset() {
        pattern.clear();
        player.clear();
        score = 0;
    }
}
