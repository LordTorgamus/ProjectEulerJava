package utils.math;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.math.Prime;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

public class PrimeTest {
    @Test
    public void test() {
        testFactorize();
    }

    @Test
    public void testFactorize() {
        Multiset<Long> two = TreeMultiset.create();
        two.add(2L);
        assertEquals(two, Prime.factorize(2));
        
        Multiset<Long> three = TreeMultiset.create();
        three.add(3L);
        assertEquals(three, Prime.factorize(3));
        
        Multiset<Long> sixteen = TreeMultiset.create();
        sixteen.add(2L);
        sixteen.add(2L);
        sixteen.add(2L);
        sixteen.add(2L);
        assertEquals(sixteen, Prime.factorize(16));
        
        Multiset<Long> fortyTwo = TreeMultiset.create();
        fortyTwo.add(7L);
        fortyTwo.add(3L);
        fortyTwo.add(2L);
        assertEquals(fortyTwo, Prime.factorize(42));
    }
}
