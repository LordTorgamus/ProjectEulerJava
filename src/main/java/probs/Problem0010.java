package probs;

import java.util.List;

import utils.euler.EulerProblem;
import utils.math.Prime;

/**
 * Project Euler problem 10
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * @author Lord Torgamus
 */
public class Problem0010 extends EulerProblem {
    int CEILING;
    
    {
        CEILING = 2000000;
    }
    
    public static void main(String[] args) throws Exception {
        run(new Problem0010());
    }

    @Override
    protected long doProblemSpecificStuff() {
        long sumOfPrimesUpToCeiling = 0;
        
        Prime.sieveOfErastosthenes(CEILING);
        List<Integer> knownPrimes = Prime.getKnownPrimes();
        
        for(Integer i : knownPrimes) {
            sumOfPrimesUpToCeiling += i;
        }
        
        return sumOfPrimesUpToCeiling;
    }
}
