package org.example;

public class Recursia2 {
    public static void main(String[] args){
        rec(123);
    }

    private static void rec(int n) {
        if (n >= 0 && n < 10) {
            System.out.print(shiftDigit(n));
            return;
        }

        rec(n / 10);

        System.out.print(shiftDigit(n % 10));
    }

    private static int shiftDigit(int digit) {
        return (digit + 1) % 10;
    }
}
