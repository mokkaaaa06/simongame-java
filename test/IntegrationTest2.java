
import static org.junit.Assert.*;
import org.junit.Test;

public class IntegrationTest2 {

    @Test
    public void testMultipleRoundsIncreaseScore() {
        GameLogic logic = new GameLogic();

        logic.nextRound();
        int first = logic.getPattern().get(0);
        logic.checkInput(first);

        logic.nextRound();
        int second = logic.getPattern().get(1);
        logic.checkInput(first);
        logic.checkInput(second);

        assertEquals(2, logic.getScore());
    }
}
