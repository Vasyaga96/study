package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumToEnglishTest {

    @Test
    void testNumberToEnglish() {
        assertEquals("one", NumToEnglish2.numberToEnglish(1));
        assertEquals("twenty three", NumToEnglish2.numberToEnglish(23));
        assertEquals("twelve", NumToEnglish2.numberToEnglish(12));
        assertEquals("one hundred twenty three", NumToEnglish2.numberToEnglish(123));
        assertEquals("one hundred two", NumToEnglish2.numberToEnglish(102));
        assertEquals("one hundred twenty", NumToEnglish2.numberToEnglish(120));
        assertEquals("one thousand two hundred thirty four", NumToEnglish2.numberToEnglish(1234));
        assertEquals("one thousand one", NumToEnglish2.numberToEnglish(1001));
        assertEquals("twelve thousand", NumToEnglish2.numberToEnglish(12000));
        assertEquals("one million one hundred twenty three", NumToEnglish2.numberToEnglish(1000123));
        assertEquals("minus one hundred twenty three", NumToEnglish2.numberToEnglish(-123));
        assertEquals("zero", NumToEnglish2.numberToEnglish(0));

    }
}