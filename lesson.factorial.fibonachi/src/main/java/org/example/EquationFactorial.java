package org.example;

import java.util.Scanner;

public class EquationFactorial {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число m: ");
        int m = scanner.nextInt();
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();
        int c = factorialFor(n) / (factorialFor(n - m) * factorialFor(m));
        System.out.println(c);
    }
    private static int factorialFor(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
