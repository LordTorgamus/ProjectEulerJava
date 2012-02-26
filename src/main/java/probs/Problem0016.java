package probs;

import java.math.BigInteger;

import utils.euler.EulerProblem;

/**
 * Project Euler problem 16
 * 
 * 2<sup>15</sup> = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2<sup>1000</sup>?
 * 
 * @author Lord Torgamus
 */
public class Problem0016 extends EulerProblem {
    public static final int BASE     = 2;
    public static final int EXPONENT = 1000;

    public static void main(String[] args) throws Exception {
        run(new Problem0016());
    }

    @Override
    protected long doProblemSpecificStuff() {
        BigInteger digitsToAdd = new BigInteger(Integer.toString(BASE));
        digitsToAdd = digitsToAdd.pow(EXPONENT);

        int sum = 0;
        while(!digitsToAdd.equals(BigInteger.ZERO)) {
            int ones = digitsToAdd.mod(BigInteger.TEN).intValue();
            sum += ones;
            digitsToAdd = digitsToAdd.divide(BigInteger.TEN);
        }

        return sum;
    }
}
