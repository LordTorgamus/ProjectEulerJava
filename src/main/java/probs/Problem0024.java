package probs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.euler.EulerProblem;

/**
 * Project Euler problem 24
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the
 * permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * 
 * @author Lord Torgamus
 */
public class Problem0024 extends EulerProblem {
    public static final int MILLION = 1000000;
    private List<Long> permutations;
    
    public static void main(String[] args) throws Exception {
        run(new Problem0024());
    }

    @Override
    protected long doProblemSpecificStuff() {
        // PSEUDOCODE for generating permutations in lexicographic order (first attempt):
        //
        // Select the smallest possible number (0) as the first digit
        // Select the smallest possible number (1, since 0 is taken) as the second digit
        // Select the smallest possible number (2, since 0 and 1 are taken) as the third digit
        // Continue this way until the first permutation in lexicographic order is generated (0123456789, or 123,456,789)
        // Go "up one level" and select the smallest possible number (no such number, since 0-8 are unavailable and 9 was already used)
        // Go up again and select the smallest possible number (9, since 0-7 are taken and 8 was already used)
        // Select the smallest possible number (8, since all others are taken) to generate the next permutation (01234456798, or 123,456,798)
        // Continue this pattern until the millionth permutation is reached
        //
        // Analysis: terrible, since it relies on so many levels of nested loops

        // PSEUDOCODE for alternate approach
        //
        // Just generate all the permutations and run a sort
        //
        // Analysis: also nested loops, but less difficult to code

        permutations = new ArrayList<Long>(MILLION);
        populatePermutations();
        Collections.sort(permutations); // A pain, but nothing compared to the O(n^10) we just went through

        return permutations.get(MILLION - 1); // Fencepost (AKA off-by-one)
    }
    
    private void populatePermutations() {
        for(int one = 0; one < 10; one++) {
            for(int two = 0; two < 10; two++) {
                if(two == one) {
                    continue;
                }
                for(int three = 0; three < 10; three++) {
                    // @formatter:off
                    if(three == two ||
                       three == one) {
                        continue;
                    }
                    // @formatter:on
                    for(int four = 0; four < 10; four++) {
                        // @formatter:off
                        if(four == three ||
                           four == two ||
                           four == one) {
                            continue;
                        }
                        // @formatter:on
                        for(int five = 0; five < 10; five++) {
                            // @formatter:off
                            if(five == four ||
                               five == three ||
                               five == two ||
                               five == one) {
                                continue;
                            }
                            // @formatter:on
                            for(int six = 0; six < 10; six++) {
                                // @formatter:off
                                if(six == five ||
                                   six == four ||
                                   six == three ||
                                   six == two ||
                                   six == one) {
                                    continue;
                                }
                                // @formatter:on
                                for(int seven = 0; seven < 10; seven++) {
                                    // @formatter:off
                                    if(seven == six ||
                                       seven == five ||
                                       seven == four ||
                                       seven == three ||
                                       seven == two ||
                                       seven == one) {
                                        continue;
                                    }
                                    // @formatter:on
                                    for(int eight = 0; eight < 10; eight++) {
                                        // @formatter:off
                                        if(eight == seven ||
                                           eight == six ||
                                           eight == five ||
                                           eight == four ||
                                           eight == three ||
                                           eight == two ||
                                           eight == one) {
                                            continue;
                                        }
                                        // @formatter:on
                                        for(int nine = 0; nine < 10; nine++) {
                                            // @formatter:off
                                            if(nine == eight ||
                                               nine == seven ||
                                               nine == six ||
                                               nine == five ||
                                               nine == four ||
                                               nine == three ||
                                               nine == two ||
                                               nine == one) {
                                                continue;
                                            }
                                            // @formatter:on
                                            for(int ten = 0; ten < 10; ten++) {
                                                // @formatter:off
                                                if(ten == nine ||
                                                   ten == eight ||
                                                   ten == seven ||
                                                   ten == six ||
                                                   ten == five ||
                                                   ten == four ||
                                                   ten == three ||
                                                   ten == two ||
                                                   ten == one) {
                                                    continue;
                                                }

                                                long current = ten /* * 1 */       +
                                                               nine   * 10         +
                                                               eight  * 100        +
                                                               seven  * 1000       +
                                                               six    * 10000      +
                                                               five   * 100000     +
                                                               four   * 1000000    +
                                                               three  * 10000000L  +
                                                               two    * 100000000L +
                                                               one    * 1000000000L;
                                                // @formatter:on

                                                permutations.add(current);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
