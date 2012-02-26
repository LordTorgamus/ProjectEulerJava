package utils.math;

import java.util.HashSet;
import java.util.Set;

import utils.collections.CollectionUtils;

public class MathUtils {
    public static final int TWO = 2;

    public static int max(int... vals) {
        int greatest = -1;

        for(int i : vals) {
            if(i > greatest) {
                greatest = i;
            }
        }

        return greatest;
    }

    public static int countDivisors(int number) {
        int numDivisors = 0;

        // Divisors come in pairs: one lower than the number's square root and one greater
        // Exception: the square root itself, if an integer, is one divisor

        int sqRtOfNum = (int) Math.sqrt(number);
        for(int possibleDivisor = 1; possibleDivisor < sqRtOfNum; possibleDivisor++) {
            if(isDivisibleBy(number, possibleDivisor)) {
                numDivisors += 2;
            }
        }

        if(isPerfectSquare(number)) {
            numDivisors++;
        }

        return numDivisors;
    }

    /**
     * Proper divisors include all of a number's "normal" divisors except for itself. One is a proper divisor of every integer.
     * 
     * @param number
     * @return
     */
    public static Set<Integer> getProperDivisors(int number) {
        Set<Integer> properDivisors = new HashSet<Integer>();

        int sqRtOfNum = (int) Math.sqrt(number);
        for(int possibleDivisor = 1; possibleDivisor <= sqRtOfNum; possibleDivisor++) {
            if(isDivisibleBy(number, possibleDivisor)) {
                properDivisors.add(possibleDivisor);
                properDivisors.add(number / possibleDivisor);
            }
        }

        properDivisors.remove(number);
        
        return properDivisors;
    }

    public static boolean isAbundantNumber(int number) {
        Set<Integer> properDivisors = getProperDivisors(number);
        long sumOfDivisors = CollectionUtils.getSum(properDivisors);

        if(sumOfDivisors > number) {
            return true;
        }
        return false;
    }

    public static boolean isDivisibleBy(long dividend, long divisor) {
        if(dividend % divisor == 0) {
            return true;
        }

        return false;
    }

    public static boolean isEven(long number) {
        return isDivisibleBy(number, TWO);
    }

    public static boolean isPerfectSquare(int number) {
        int sqRtOfNum = (int) Math.sqrt(number);

        if(sqRtOfNum * sqRtOfNum == number) {
            return true;
        }

        return false;
    }
}
