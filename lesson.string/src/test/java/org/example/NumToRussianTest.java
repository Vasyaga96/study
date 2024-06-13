package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumToRussianTest {

    @Test
    void numberToRussian() {
        assertEquals("один", NumToRussian.numberToRussian(1));
        assertEquals("двадцать три", NumToRussian.numberToRussian(23));
        assertEquals("двенадцать", NumToRussian.numberToRussian(12));
        assertEquals("сто двадцать три", NumToRussian.numberToRussian(123));
        assertEquals("сто два", NumToRussian.numberToRussian(102));
        assertEquals("сто двадцать", NumToRussian.numberToRussian(120));
        assertEquals("восемьсот девяносто один", NumToRussian.numberToRussian(891));
//        assertEquals("одна тысяча двести дридцать четыре", NumToEnglish2.numberToEnglish(1234));
//        assertEquals("одна тысяча один", NumToEnglish2.numberToEnglish(1001));
//        assertEquals("двенадцать тысяч", NumToEnglish2.numberToEnglish(12000));
//        assertEquals("один миллион сто двадцать три", NumToEnglish2.numberToEnglish(1000123));
//        assertEquals("минус сто двадцать три", NumToEnglish2.numberToEnglish(-123));
//        assertEquals("ноль", NumToEnglish2.numberToEnglish(0));
    }
}