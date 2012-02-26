package probs;

import com.google.common.collect.Multiset;

import utils.euler.EulerProblem;
import utils.math.Prime;

/**
 * Project Euler problem 3
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author Lord Torgamus
 */
public class Problem0003 extends EulerProblem {
    public static void main(String[] args) {
        run(new Problem0003());
    }

    @Override
    protected long doProblemSpecificStuff() {
        long NUMBER = 600851475143L;

        Multiset<Integer> factors = Prime.factorize(NUMBER);
        Integer[] factorArray = factors.toArray(new Integer[0]);
        int largestPrimeFactor = factorArray[factorArray.length - 1];

        return largestPrimeFactor;
    }
}
