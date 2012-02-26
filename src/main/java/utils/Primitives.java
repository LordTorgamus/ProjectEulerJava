package utils;

public class Primitives {
    public static final byte CHAR_DIGIT_VALUE_OFFSET = 48;
    public static final byte CHAR_UPPERCASE_LETTER_VALUE_OFFSET = 64;
    public static final byte CHAR_LOWERCASE_LETTER_VALUE_OFFSET = 96;

    public static byte convertDigitToByte(char digit) {
        return (byte) (digit - CHAR_DIGIT_VALUE_OFFSET);
    }

    public static byte convertUppercaseLetterToByte(char uppercaseLetter) {
        return (byte) (uppercaseLetter - CHAR_UPPERCASE_LETTER_VALUE_OFFSET);
    }

    public static byte convertLowercaseLetterToByte(char lowercaseLetter) {
        return (byte) (lowercaseLetter - CHAR_LOWERCASE_LETTER_VALUE_OFFSET);
    }
}
