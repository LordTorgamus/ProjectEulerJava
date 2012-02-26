package probs;

import utils.euler.EulerProblem;

/**
 * Project Euler problem 1
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author Lord Torgamus
 */
public class Problem0001 extends EulerProblem {
    public static void main(String[] args) {
        run(new Problem0001());
    }

    @Override
    protected long doProblemSpecificStuff() {
        int total = 0;

        for(int i = 1; i < 1000; i++) {
            if(i % 3 == 0) {
                total += i;
                continue;
            }
            if(i % 5 == 0) {
                total += i;
            }
        }

        return total;
    }
}