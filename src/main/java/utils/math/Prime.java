package utils.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

public class Prime {
    private static SortedSet<Integer> knownPrimes;        // Complete list of primes from two to n for some integer n greater than or equal to two
    private static int                largestValueChecked;

    static {
        reset();
    }
    
    public static void reset() {
        knownPrimes = new TreeSet<Integer>();
        knownPrimes.add(2);
        largestValueChecked = 2;
    }

    public static int numOfKnownPrimes() {
        return knownPrimes.size();
    }

    public static int largestKnownPrime() {
        return knownPrimes.last();
    }
    
    public static List<Integer> getKnownPrimes() {
        return new LinkedList<Integer>(knownPrimes);
    }

    /**
     * Determines whether a given number is prime.
     * 
     * By definition, two is the smallest prime number.
     * 
     * @param potentialPrime
     * @param smallerPrimes
     * @return whether or not the parameter is a prime number
     */
    public static boolean isPrime(int potentialPrime) {
        if(isKnownPrime(potentialPrime)) {
            return true;
        }

        if(potentialPrime < largestValueChecked) {
            return false;
        }

        sieveOfErastosthenes(potentialPrime);

        return knownPrimes.contains(potentialPrime);
    }

    private static boolean isKnownPrime(int potentialPrime) {
        if(knownPrimes.contains(potentialPrime)) {
            return true;
        }

        return false;
    }

    /**
     * Calculates the primacy of every integer between two and the parameter, inclusive.
     * 
     * This method must not call isPrime(), because it is used by isPrime(). It is safe for this method to call isKnownPrime().
     * 
     * @param limit
     */
    public static void sieveOfErastosthenes(int limit) {
        if(limit < 2) {
            throw new IllegalArgumentException("Potential prime must be an integer greater than or equal to two.");
        }

        if(limit < largestValueChecked) {
            return;
        }

        boolean[] isPrime = new boolean[(limit + 1)];
        for(int i = 0; i < limit; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;

        for(int multipleOf = 2; multipleOf <= limit; multipleOf++) {
            for(int index = 2 * multipleOf; index <= limit; index += multipleOf) {
                isPrime[index] = false;
            }
        }

        knownPrimes = new TreeSet<Integer>();
        for(int i = 0; i < limit; i++) {
            if(isPrime[i]) {
                knownPrimes.add(i);
            }
        }
        largestValueChecked = limit;
    }

    /**
     * 
     * 
     * @param numToFactor
     * @return all factors of the parameter except for one and itself
     */
    public static Multiset<Integer> factorize(long numToFactor) {
        if(numToFactor == 2) {
            Multiset<Integer> factorsOfTwo = TreeMultiset.create();
            factorsOfTwo.add(2);
            return factorsOfTwo;
        }
        if(numToFactor == 3) {
            Multiset<Integer> factorsOfThree = TreeMultiset.create();
            factorsOfThree.add(3);
            return factorsOfThree;
        }

        ArrayList<Integer> factors = new ArrayList<Integer>();
        int rootOfNumToFactor = (int) Math.sqrt(numToFactor);
        List<Integer> possibleFactors = retrievePrimesSmallerThan(rootOfNumToFactor + 1);

        // Account for perfect squares
        if(rootOfNumToFactor * rootOfNumToFactor == numToFactor) {
            possibleFactors.add(rootOfNumToFactor);
        }

        int numPossibleFactors = possibleFactors.size();
        long numBeingFactored = numToFactor;

        // if the number is divisible by a prime, add that prime to the list and try it again
        // if the number is not divisible by a prime, move on to the next prime
        // every number can have at most one factor that is greater than its square root
        for(int i = 0; i < numPossibleFactors;) {
            int possibleFactor = possibleFactors.get(i);

            if(MathUtils.isDivisibleBy(numBeingFactored, possibleFactor)) {
                numBeingFactored /= possibleFactor;
                factors.add(possibleFactor);

                if(numBeingFactored == 1) {
                    return TreeMultiset.create(factors);
                }
            } else {
                i++;
            }
        }

        factors.add((int) numBeingFactored);

        return TreeMultiset.create(factors);
    }

    /**
     * By definition, two is the smallest prime number.
     * 
     * @param limit
     * @return a list of all prime numbers less than or equal to some limit value
     */
    private static List<Integer> retrievePrimesSmallerThan(int limit) {
        sieveOfErastosthenes(limit);

        SortedSet<Integer> primesSmallerThanLimit = knownPrimes.headSet(limit);

        return new ArrayList<Integer>(primesSmallerThanLimit);
    }

    /**
     * Check the next integer greater than the largest value checked so far for primacy. Repeat until a prime number is found.
     */
    public static void calculateNextPrime() {
        int numBeingChecked = largestValueChecked + 1;

        checkNextNumber:
        while(true) {
            int sqRtOfNumBeingChecked = ((int) Math.sqrt(numBeingChecked)) + 1;

            SortedSet<Integer> potentialFactorsSet = knownPrimes.headSet(sqRtOfNumBeingChecked);
            Integer[] potentialFactors = potentialFactorsSet.toArray(new Integer[0]);

            int numPotentialFactors = potentialFactors.length;

            for(int potentialFactorIndex = 0; potentialFactorIndex < numPotentialFactors; potentialFactorIndex++) {
                int potentialFactor = potentialFactors[potentialFactorIndex];

                if(MathUtils.isDivisibleBy(numBeingChecked, potentialFactor)) {
                    largestValueChecked = numBeingChecked;
                    numBeingChecked++;
                    continue checkNextNumber;
                }
            }

            knownPrimes.add(numBeingChecked);
            largestValueChecked = numBeingChecked;
            return;
        }
    }
}
