package probs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.euler.EulerProblem;
import utils.math.Prime;

public abstract class ProblemTest {
    protected EulerProblem instance;
    
    @Before
    public abstract void setUp() throws Exception;
    
    @Test
    public abstract void testResult();

    @Test
    public abstract void testRunningTime();
    
    @After
    public void tearDown() {
        Prime.reset();
    }
}
