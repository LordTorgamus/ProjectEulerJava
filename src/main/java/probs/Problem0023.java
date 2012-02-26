package probs;

import java.util.ArrayList;
import java.util.List;

import utils.euler.EulerProblem;
import utils.math.MathUtils;

/**
 * Project Euler problem 23
 * 
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors
 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this
 * upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two
 * abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * 
 * @author Lord Torgamus
 */
public class Problem0023 extends EulerProblem {
    public static final int ABUNDANT_NUMBER_SUM_CAP;

    static {
        ABUNDANT_NUMBER_SUM_CAP = 28123;
    }

    public static void main(String[] args) throws Exception {
        run(new Problem0023());
    }

    @Override
    protected long doProblemSpecificStuff() {
        List<Integer> abundantNumbers = getAbundantNumbers();

        boolean[] isAbundantNumberSum = calculateAbundantNumberSums(abundantNumbers);

        int sumOfNonAbundantSums = 0;
        for(int i = 0; i < ABUNDANT_NUMBER_SUM_CAP; i++) {
            if(!isAbundantNumberSum[i]) {
                sumOfNonAbundantSums += i;
            }
        }

        return sumOfNonAbundantSums;
    }

    private List<Integer> getAbundantNumbers() {
        List<Integer> abundantNumbers = new ArrayList<Integer>();

        for(int i = 1; i < ABUNDANT_NUMBER_SUM_CAP; i++) {
            if(MathUtils.isAbundantNumber(i)) {
                abundantNumbers.add(i);
            }
        }

        return abundantNumbers;
    }

    private boolean[] calculateAbundantNumberSums(List<Integer> abundantNumbers) {
        boolean[] isAbundantNumberSum = new boolean[ABUNDANT_NUMBER_SUM_CAP];

        for(int i = 0; i < ABUNDANT_NUMBER_SUM_CAP; i++) {
            isAbundantNumberSum[i] = false;
        }

        int numOfAbundantNumbers = abundantNumbers.size();
        for(int i = 0; i < numOfAbundantNumbers; i++) {
            for(int j = i; j < numOfAbundantNumbers; j++) {
                int sum = abundantNumbers.get(i) + abundantNumbers.get(j);
                
                if(sum >= ABUNDANT_NUMBER_SUM_CAP) {
                    break;
                }
                
                isAbundantNumberSum[sum] = true;
            }
        }

        return isAbundantNumberSum;
    }
}
