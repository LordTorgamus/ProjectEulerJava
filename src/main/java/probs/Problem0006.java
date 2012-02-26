package probs;

import utils.euler.EulerProblem;

/**
 * Project Euler problem 6
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 1<sup>2</sup> + 2<sup>2</sup> + ... + 10<sup>2</sup> = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)<sup>2</sup> = 552 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * @author Lord Torgamus
 */
public class Problem0006 extends EulerProblem {
    public static void main(String[] args) {
        run(new Problem0006());
    }

    @Override
    protected long doProblemSpecificStuff() {
        int difference = 1;
        int sumOfSquares = 0;
        int squareOfSums = 0;

        for(int i = 1; i <= 100; i++) {
            squareOfSums += i;

            sumOfSquares += (i * i);
        }
        squareOfSums *= squareOfSums;

        difference = squareOfSums - sumOfSquares;

        return difference;
    }
}
