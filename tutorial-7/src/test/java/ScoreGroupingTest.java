import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ScoreGroupingTest {

    private Map<String, Integer> uniform = new HashMap<>();
    private Map<String, Integer> unique = new HashMap<>();
    private Map<String, Integer> case0 = new HashMap<>();

    @Before
    public void setUp() {
        case0.put("Alice", 12);
        case0.put("Bob", 15);
        case0.put("Charlie", 11);
        case0.put("Delta", 15);
        case0.put("Emi", 15);
        case0.put("Foxtrot", 11);

        uniform.put("Alice", 10);
        uniform.put("Bob", 10);
        uniform.put("Charlie", 10);
        uniform.put("Delta", 10);
        uniform.put("Emi", 10);
        uniform.put("Foxtrot", 10);

        unique.put("Alice", 12);
        unique.put("Bob", 13);
        unique.put("Charlie", 11);
        unique.put("Delta", 10);
        unique.put("Emi", 15);
        unique.put("Foxtrot", 14);
    }

    @Test
    public void testDefaultDataset() {
        assertEquals("{11=[Charlie, Foxtrot], 12=[Alice], 15=[Emi, Bob, Delta]}",
                ScoreGrouping.groupByScores(case0).toString());
    }

    @Test
    public void testUniformDataset() {
        assertEquals("{10=[Emi, Bob, Delta, Alice, Charlie, Foxtrot]}",
                ScoreGrouping.groupByScores(uniform).toString());
    }

    @Test
    public void testUniqueDataset() {
        assertEquals("{10=[Delta], 11=[Charlie], 12=[Alice], 13=[Bob], 14=[Foxtrot], 15=[Emi]}",
                ScoreGrouping.groupByScores(unique).toString());
    }
}