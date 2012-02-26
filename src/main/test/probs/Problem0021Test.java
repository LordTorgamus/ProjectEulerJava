package probs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import utils.euler.EulerProblem;

public class Problem0021Test extends ProblemTest {
    @Override
    @Before
    public void setUp() throws Exception {
        instance = new Problem0021();
        EulerProblem.run(instance);
    }

    @Override
    @Test
    public void testResult() {
        assertEquals(31626L, instance.getAnswer());
    }

    @Override
    @Test
    public void testRunningTime() {
        assertTrue(instance.getRunningTime() <= 60);
    }
}
