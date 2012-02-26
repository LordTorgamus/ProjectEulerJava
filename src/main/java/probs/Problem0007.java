package probs;

import utils.euler.EulerProblem;
import utils.math.Prime;

/**
 * Project Euler problem 7
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * @author Lord Torgamus
 */
public class Problem0007 extends EulerProblem {
    public static void main(String[] args) {
        run(new Problem0007());
    }

    @Override
    protected long doProblemSpecificStuff() {
        while(Prime.numOfKnownPrimes() < 10001) {
            Prime.calculateNextPrime();
        }

        int prime10001 = Prime.largestKnownPrime();

        return prime10001;
    }
}
