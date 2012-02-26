package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimitivesTest {
    @Test
    public void testConvertDigitToByte() {
        assertEquals(0, Primitives.convertDigitToByte('0'));
        assertEquals(1, Primitives.convertDigitToByte('1'));
        assertEquals(2, Primitives.convertDigitToByte('2'));
        assertEquals(3, Primitives.convertDigitToByte('3'));
        assertEquals(4, Primitives.convertDigitToByte('4'));
        assertEquals(5, Primitives.convertDigitToByte('5'));
        assertEquals(6, Primitives.convertDigitToByte('6'));
        assertEquals(7, Primitives.convertDigitToByte('7'));
        assertEquals(8, Primitives.convertDigitToByte('8'));
        assertEquals(9, Primitives.convertDigitToByte('9'));
    }
}
