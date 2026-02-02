
import static org.junit.Assert.*;
import org.junit.Test;

public class IntegrationTest1 {

    @Test
    public void testLogicToScoreManager() {
        GameLogic logic = new GameLogic();
        ScoreManager sm = new ScoreManager();

        logic.nextRound();
        int correct = logic.getPattern().get(0);
        logic.checkInput(correct);
        sm.addScore(logic.getScore());

        assertEquals(1, sm.getTopScores().get(0).intValue());
    }
}
