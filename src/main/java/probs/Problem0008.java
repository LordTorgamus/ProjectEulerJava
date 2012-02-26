package probs;

import utils.Primitives;
import utils.euler.EulerProblem;

/**
 * Project Euler problem 8
 * 
 * Find the greatest product of five consecutive digits in the 1000-digit number.
 * 
 * 73167176531330624919225119674426574742355349194934<br>
 * 96983520312774506326239578318016984801869478851843<br>
 * 85861560789112949495459501737958331952853208805511<br>
 * 12540698747158523863050715693290963295227443043557<br>
 * 66896648950445244523161731856403098711121722383113<br>
 * 62229893423380308135336276614282806444486645238749<br>
 * 30358907296290491560440772390713810515859307960866<br>
 * 70172427121883998797908792274921901699720888093776<br>
 * 65727333001053367881220235421809751254540594752243<br>
 * 52584907711670556013604839586446706324415722155397<br>
 * 53697817977846174064955149290862569321978468622482<br>
 * 83972241375657056057490261407972968652414535100474<br>
 * 82166370484403199890008895243450658541227588666881<br>
 * 16427171479924442928230863465674813919123162824586<br>
 * 17866458359124566529476545682848912883142607690042<br>
 * 24219022671055626321111109370544217506941658960408<br>
 * 07198403850962455444362981230987879927244284909188<br>
 * 84580156166097919133875499200524063689912560717606<br>
 * 05886116467109405077541002256983155200055935729725<br>
 * 71636269561882670428252483600823257530420752963450
 * 
 * @author Lord Torgamus
 */
public class Problem0008 extends EulerProblem {
    String INPUT;
    int SEQUENCE_LENGTH;
    
    {
        INPUT = "";
        INPUT += "73167176531330624919225119674426574742355349194934";
        INPUT += "96983520312774506326239578318016984801869478851843";
        INPUT += "85861560789112949495459501737958331952853208805511";
        INPUT += "12540698747158523863050715693290963295227443043557";
        INPUT += "66896648950445244523161731856403098711121722383113";
        INPUT += "62229893423380308135336276614282806444486645238749";
        INPUT += "30358907296290491560440772390713810515859307960866";
        INPUT += "70172427121883998797908792274921901699720888093776";
        INPUT += "65727333001053367881220235421809751254540594752243";
        INPUT += "52584907711670556013604839586446706324415722155397";
        INPUT += "53697817977846174064955149290862569321978468622482";
        INPUT += "83972241375657056057490261407972968652414535100474";
        INPUT += "82166370484403199890008895243450658541227588666881";
        INPUT += "16427171479924442928230863465674813919123162824586";
        INPUT += "17866458359124566529476545682848912883142607690042";
        INPUT += "24219022671055626321111109370544217506941658960408";
        INPUT += "07198403850962455444362981230987879927244284909188";
        INPUT += "84580156166097919133875499200524063689912560717606";
        INPUT += "05886116467109405077541002256983155200055935729725";
        INPUT += "71636269561882670428252483600823257530420752963450";
        
        SEQUENCE_LENGTH = 5;
    }
    
    public static void main(String[] args) {
        run(new Problem0008());
    }

    @Override
    protected long doProblemSpecificStuff() {
        byte[] inputArray = convertInputToArray(INPUT);
        
        int inputLength = inputArray.length; // Should be 1000
        int product = inputArray[0] * inputArray[1] * inputArray[2] * inputArray[3] * inputArray[4];
        int largestProduct = product;
        
        // Each sequence of digits has four digits in common with its predecessor.
        // Therefore, doing all the multiplication for each sequence would be wasteful.
        // Instead, compute products by removing the old first digit and adding the new fifth digit.
        // Exception: this algorithm is susceptible to divide-by-zero errors; redo all the multiplication if the removed digit is zero
        // Keep track of the largest product encountered thus far
        for(int headIndex = SEQUENCE_LENGTH; headIndex < inputLength; headIndex++) {
            int digitToRemove = inputArray[headIndex - SEQUENCE_LENGTH];
            int digitToAdd = inputArray[headIndex];
            
            if(digitToRemove == 0) {
                product = 1;
                for(int i = 1; i < SEQUENCE_LENGTH; i++) {
                    product *= inputArray[headIndex - i];
                }
            }
            else {
                product /= digitToRemove;                
            }

            product *= digitToAdd;
            // Potential minor optimization:
            // If the digit to add is zero, skip the next five (actually technically SEQUENCE_LENGTH) values; they're all going to be zero anyways
            
            if(product > largestProduct) {
                largestProduct = product;
            }
        }
        
        return largestProduct;
    }
    
    private byte[] convertInputToArray(String inputString) {
        int numOfDigits = inputString.length();
        byte[] array = new byte[numOfDigits];
        
        for(int i = 0; i < numOfDigits; i++) {
            char digit = inputString.charAt(i);
            array[i] = Primitives.convertDigitToByte(digit);
        }
        
        return array;
    }
}
