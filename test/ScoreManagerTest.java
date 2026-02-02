
import static org.junit.Assert.*;
import org.junit.Test;

public class ScoreManagerTest {

    @Test
    public void testTopTenLimit() {
        ScoreManager sm = new ScoreManager();
        for(int i=0;i<20;i++){
            sm.addScore(i);
        }
        assertEquals(10, sm.getTopScores().size());
    }
}
