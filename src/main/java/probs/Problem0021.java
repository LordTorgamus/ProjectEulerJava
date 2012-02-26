package probs;

import java.util.HashSet;
import java.util.Set;

import utils.collections.CollectionUtils;
import utils.euler.EulerProblem;
import utils.math.MathUtils;

/**
 * Project Euler problem 21
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are
 * 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @author Lord Torgamus
 */
public class Problem0021 extends EulerProblem {
    private static final int MAX_VALUE;

    static {
        MAX_VALUE = 10000;
    }

    public static void main(String[] args) throws Exception {
        run(new Problem0021());
    }

    @Override
    protected long doProblemSpecificStuff() {
        Set<Integer> amicableNumbers = new HashSet<Integer>();

        for(int a = 1; a <= MAX_VALUE; a++) {
            Set<Integer> divisorsOfA = MathUtils.getProperDivisors(a);
            int sumOfDivisorsOfA = (int) CollectionUtils.getSum(divisorsOfA);
            if(sumOfDivisorsOfA == a) {
                continue;
            }

            Set<Integer> divisorsOfB = MathUtils.getProperDivisors(sumOfDivisorsOfA);
            int sumOfDivisorsOfB = (int) CollectionUtils.getSum(divisorsOfB);
            if(sumOfDivisorsOfB == a) {
                amicableNumbers.add(sumOfDivisorsOfB);
                amicableNumbers.add(a);
            }
        }

        return CollectionUtils.getSum(amicableNumbers);
    }
}
