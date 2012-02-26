package probs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import utils.euler.EulerProblem;
import utils.math.MathUtils;

/**
 * Project Euler problem 14
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @author Lord Torgamus
 */
public class Problem0014 extends EulerProblem {
    int                   START_CEILING;

    Map<Long, Integer> knownDistances;
    int                   longestChainLength;
    int                   longestChainStartValue;

    {
        START_CEILING = 1000000;

        knownDistances = new HashMap<Long, Integer>();
        knownDistances.put(1L, 1); // Base case
        
        longestChainLength = -1;
        longestChainStartValue = -1;
    }

    public static void main(String[] args) throws Exception {
        run(new Problem0014());
    }

    @Override
    protected long doProblemSpecificStuff() {
        for(int startingNumber = 1; startingNumber < START_CEILING; startingNumber++) {
            Stack<Long> subchain = getSubchain(startingNumber);

            long elementSeenBefore = subchain.pop();
            int lengthToElementSeenBefore = knownDistances.get(elementSeenBefore);
            
            int numNewValues = subchain.size();
            for(int i = 1; i <= numNewValues; i++) {
                Long nextLinkInChain = subchain.pop();
                int lengthToNextLink = lengthToElementSeenBefore + i;
                knownDistances.put(nextLinkInChain, lengthToNextLink);
            }

            int chainLength = numNewValues + lengthToElementSeenBefore;
            if(chainLength > longestChainLength) {
                longestChainLength = chainLength;
                longestChainStartValue = startingNumber;
            }
        }

        return longestChainStartValue;
    }

    /**
     * Computes the portion of the chain starting with the given number that contains previously unseen values.
     * 
     * @param startingNumber the value at the head of the chain
     * @return the part of the chain that has previously unseen values, plus the first known value
     */
    protected Stack<Long> getSubchain(long startingNumber) {
        Stack<Long> chain = new Stack<Long>();
        chain.push(startingNumber);
        
        long calculatedNumber = startingNumber;
        while(!seenBefore(calculatedNumber)) {
            calculatedNumber = getNextNumberInSequence(calculatedNumber);
            chain.push(calculatedNumber);
        }

        return chain;
    }
    
    protected boolean seenBefore(long startingNumber) {
        return knownDistances.containsKey(startingNumber);
    }
    
    protected long getNextNumberInSequence(long curNum) {
        if(MathUtils.isEven(curNum)) {
            return curNum / 2;
        }
        return 3 * curNum + 1;
    }
}
