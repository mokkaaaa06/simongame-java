
import static org.junit.Assert.*;
import org.junit.Test;

public class GameLogicTest {

    @Test
    public void testScoreIncrease() {
        GameLogic logic = new GameLogic();
        logic.nextRound();
        int correct = logic.getPattern().get(0);
        logic.checkInput(correct);
        assertEquals(1, logic.getScore());
    }
}
