package probs;

import java.util.Set;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import utils.euler.EulerProblem;
import utils.math.Prime;

/**
 * Project Euler problem 5
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author Lord Torgamus
 */
public class Problem0005 extends EulerProblem {
    public static void main(String[] args) {
        run(new Problem0005());
    }

    @Override
    protected long doProblemSpecificStuff() {
        int HIGH_VAL = 20;

        Multiset<Integer> factors = isolateUniqueFactors(HIGH_VAL);
        int smallestProduct = calculateProduct(factors);

        return smallestProduct;
    }

    private static Multiset<Integer> isolateUniqueFactors(int limit) {
        Multiset<Integer> factors = TreeMultiset.create();

        for(int mustBeDivisibleBy = 2; mustBeDivisibleBy <= limit; mustBeDivisibleBy++) {
            Multiset<Integer> currentFactors = Prime.factorize(mustBeDivisibleBy);

            addMissingFactors(factors, currentFactors);
        }

        return factors;
    }

    // if currentFactors contains any values not already in factors, add them to factors
    private static void addMissingFactors(Multiset<Integer> factors, Multiset<Integer> currentFactors) {
        Set<Integer> uniqueCurrentFactors = currentFactors.elementSet();

        for(Integer currentFactor : uniqueCurrentFactors) {
            if(currentFactors.count(currentFactor) > factors.count(currentFactor)) {
                factors.add(currentFactor);
            }
        }
    }

    private static int calculateProduct(Multiset<Integer> factors) {
        int product = 1;

        for(Integer i : factors) {
            product *= i;
        }

        return product;
    }
}
