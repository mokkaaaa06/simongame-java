
import java.util.*;

public class ScoreManager {

    private List<Integer> scores = new ArrayList<>();

    public void addScore(int score) {
        scores.add(score);
        scores.sort(Collections.reverseOrder());
        if(scores.size() > 10){
            scores = scores.subList(0,10);
        }
    }

    public List<Integer> getTopScores() {
        return new ArrayList<>(scores);
    }
}
