package probs;

import utils.euler.EulerProblem;

/**
 * Project Euler problem 9
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * 
 * a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup>
 * 
 * For example, 3<sup>2</sup> + 4<sup>2</sup> = 9 + 16 = 25 = 5<sup>2</sup>.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author Lord Torgamus
 */
public class Problem0009 extends EulerProblem {
    public static void main(String[] args) {
        run(new Problem0009());
    }

    @Override
    protected long doProblemSpecificStuff() {
        long tripletProduct = 0;

        // Brute force
        for(int i = 1; i < 1000; i++) {
            for(int j = i + 1; j < 1000; j++) {
                for(int k = j + 1; k < 1000; k++) {
                    if(isPythagoreanTriplet(i, j, k) && sumTo1000(i, j, k)) {
                        tripletProduct = i * j * k;
                        return tripletProduct;
                    }
                }
            }
        }

        return tripletProduct;
    }

    private boolean isPythagoreanTriplet(int i, int j, int k) {
        return i * i + j * j == k * k;
    }

    private boolean sumTo1000(int i, int j, int k) {
        return i + j + k == 1000;
    }
}
