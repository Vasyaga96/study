package org.example;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        int factorialFor = factorialFor(n);
        int factorialWhile = factorialWhile(n);
        int factorialDoWhile = factorialDoWhile(n);
        System.out.println(n + "! = " + factorialFor);
        System.out.println(n + "! = " + factorialWhile);
        System.out.println(n + "! = " + factorialDoWhile);

    }

    private static int factorialFor(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static int factorialWhile(int n) {
        int i = 1;
        int result = 1;
        while(i <= n){
            result *= i;
            i++;
        }
        return result;
    }
    private static int factorialDoWhile(int n){
        int i = 1;
        int result = 1;
        do {
            result *= i;
            i++;
        }while(i <= n);
        return result;
    }
}
