package probs;

import utils.euler.EulerProblem;

/**
 * Project Euler problem 17
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen)
 * contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 * 
 * @author Lord Torgamus
 */
public class Problem0017 extends EulerProblem {
    public static final int   MAX_VALUE;
    public static final int[] lengthsOfNums;
    public static final int lengthOfAnd;

    static {
        MAX_VALUE = 1000;
        lengthsOfNums = new int[MAX_VALUE + 1];
        lengthOfAnd = "and".length();

        lengthsOfNums[0] = 0;
        lengthsOfNums[1] = "one".length();
        lengthsOfNums[2] = "two".length();
        lengthsOfNums[3] = "three".length();
        lengthsOfNums[4] = "four".length();
        lengthsOfNums[5] = "five".length();
        lengthsOfNums[6] = "six".length();
        lengthsOfNums[7] = "seven".length();
        lengthsOfNums[8] = "eight".length();
        lengthsOfNums[9] = "nine".length();
        lengthsOfNums[10] = "ten".length();
        lengthsOfNums[11] = "eleven".length();
        lengthsOfNums[12] = "twelve".length();
        lengthsOfNums[13] = "thirteen".length();
        lengthsOfNums[14] = "fourteen".length();
        lengthsOfNums[15] = "fifteen".length();
        lengthsOfNums[16] = "sixteen".length();
        lengthsOfNums[17] = "seventeen".length();
        lengthsOfNums[18] = "eighteen".length();
        lengthsOfNums[19] = "nineteen".length();
        lengthsOfNums[20] = "twenty".length();
        lengthsOfNums[30] = "thirty".length();
        lengthsOfNums[40] = "forty".length();
        lengthsOfNums[50] = "fifty".length();
        lengthsOfNums[60] = "sixty".length();
        lengthsOfNums[70] = "seventy".length();
        lengthsOfNums[80] = "eighty".length();
        lengthsOfNums[90] = "ninety".length();
        lengthsOfNums[100] = "hundred".length();
        lengthsOfNums[1000] = "thousand".length();
    }

    public static void main(String[] args) throws Exception {
        run(new Problem0017());
    }
    
    @Override
    protected long doProblemSpecificStuff() {
        long sumOfLengths = 0;
        
        for(int current = 1; current <= MAX_VALUE; current++) {
            int currentLength = getLength(current);
            
            if(current > 100 && current % 100 != 0) {
                currentLength += lengthOfAnd;
            }
            
            sumOfLengths += currentLength;
        }
        
        return sumOfLengths;
    }
    
    private int getLength(int target) {
        if(target < 100) {
            return getLengthOneOrTwoDigits(target);            
        }
        else if(target < 1000) {
            return getLengthThreeDigits(target);
        }
        else if(target < 100000) {
            return getLengthFourFiveOrSixDigits(target);
        }
        
        throw new IllegalArgumentException("Program not equipped to handle values larger than " + MAX_VALUE);
    }

    private int getLengthOneOrTwoDigits(int target) {
        switch(target) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 30:
            case 40:
            case 50:
            case 60:
            case 70:
            case 80:
            case 90:
                return lengthsOfNums[target];
            default: // Two-digit number that is a mix of a "two digit word" and a "one digit word"
                // Intentionally empty
        }
        
        int ones = target % 10;
        int tens = target / 10;
        
        return lengthsOfNums[ones] + lengthsOfNums[tens * 10];
    }
    
    private int getLengthThreeDigits(int target) {
        if(target >= 1000) {
            throw new IllegalArgumentException();
        }
        
        int hundredsLength = 0;
        int hundreds = target / 100;
        if(hundreds != 0) {
            hundredsLength = getLengthOneOrTwoDigits(hundreds) + lengthsOfNums[100];
        }

        int twoDigit = target % 100;
        
        return hundredsLength + getLengthOneOrTwoDigits(twoDigit);
    }
    
    private int getLengthFourFiveOrSixDigits(int target) {
        int thousands = target / 1000;
        int threeDigit = target % 1000;
        
        return getLengthThreeDigits(thousands) + lengthsOfNums[1000] + getLengthThreeDigits(threeDigit);
    }
}
