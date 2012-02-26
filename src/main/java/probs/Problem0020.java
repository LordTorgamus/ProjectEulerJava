package probs;

import java.math.BigInteger;

import utils.euler.EulerProblem;

/**
 * Project Euler problem 20
 * 
 * n! means n × (n - 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * @author Lord Torgamus
 */
public class Problem0020 extends EulerProblem {
    private static final int START_VALUE;

    static {
        START_VALUE = 100;
    }

    public static void main(String[] args) throws Exception {
        run(new Problem0020());
    }

    @Override
    protected long doProblemSpecificStuff() {
        BigInteger factorial = new BigInteger("1");
        for(int i = 1; i <= START_VALUE; i++) {
            factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
        }

        int sumOfDigits = 0;
        while(!factorial.equals(BigInteger.ZERO)) {
            sumOfDigits += factorial.mod(BigInteger.TEN).intValue();
            factorial = factorial.divide(BigInteger.TEN);
        }

        return sumOfDigits;
    }
}
