package probs;

import java.util.Iterator;
import java.util.TreeSet;

import utils.euler.EulerProblem;

/**
 * Project Euler problem 4
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Lord Torgamus
 */
public class Problem0004 extends EulerProblem {
    public static void main(String[] args) {
        run(new Problem0004());
    }

    @Override
    protected long doProblemSpecificStuff() {
        int largestPalindrome = -1;
        TreeSet<Integer> products = generateThreeDigitProducts();

        Iterator<Integer> iterator = products.descendingIterator();

        while(iterator.hasNext()) {
            Integer current = iterator.next();

            if(isPalindrome(current.intValue())) {
                largestPalindrome = current;
                break;
            }
        }

        return largestPalindrome;
    }

    private static TreeSet<Integer> generateThreeDigitProducts() {
        TreeSet<Integer> result = new TreeSet<Integer>();

        for(int i = 999; i >= 100; i--) {
            for(int j = i; j >= 100; j--) {
                result.add(i * j);
            }
        }

        return result;
    }

    /**
     * The smallest "three-digit product" is 100*100 = 10,000; the largest is 999*999 = 998,001. All candidates are five or six digits long.
     * 
     * @param potentialPalindrome
     * @return
     */
    private static boolean isPalindrome(int potentialPalindrome) {
        int lowestDigit;
        int secondDigit;
        int thirdDigit;
        int fourthDigit;
        int fifthDigit;
        int sixthDigit;

        lowestDigit = potentialPalindrome % 10;
        secondDigit = (potentialPalindrome / 10) % 10;
        thirdDigit = (potentialPalindrome / 100) % 10;
        fourthDigit = (potentialPalindrome / 1000) % 10;
        fifthDigit = (potentialPalindrome / 10000) % 10;
        sixthDigit = (potentialPalindrome / 100000) % 10;

        if(potentialPalindrome >= 100000) {
            // Six-digit number
            if(lowestDigit == sixthDigit && secondDigit == fifthDigit && thirdDigit == fourthDigit) {
                return true;
            }
        } else {
            // Five-digit number
            if(lowestDigit == fifthDigit && secondDigit == fourthDigit) {
                return true;
            }
        }

        return false;
    }
}
