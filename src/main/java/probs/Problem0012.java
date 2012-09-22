package probs;

import utils.euler.EulerProblem;
import utils.math.MathUtils;

/**
 * Project Euler problem 12
 * 
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7<sup>th</sup> triangle number would be
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * Let us list the factors of the first seven triangle numbers:
 * 
 * <pre>
 *      1: 1
 *      3: 1,3
 *      6: 1,2,3,6
 *     10: 1,2,5,10
 *     15: 1,3,5,15
 *     21: 1,3,7,21
 *     28: 1,2,4,7,14,28
 * </pre>
 * 
 * We can see that 28 is the first triangle number to have over five divisors.
 * 
 * What is the value of the first triangle number to have over five hundred divisors?
 * 
 * @author Lord Torgamus
 */
public class Problem0012 extends EulerProblem {
    public static final int MIN_DIVISORS;
    
    static {
        MIN_DIVISORS = 500;
    }
    
    public static void main(String[] args) throws Exception {
        run(new Problem0012());
    }

    @Override
    protected long doProblemSpecificStuff() {
        int triangleNum = 0;

        for(int i = 0; ; i++) {
            triangleNum += i;
            
            if(MathUtils.countDivisors(triangleNum) > MIN_DIVISORS) {
                return triangleNum;
            }
        }
    }
}