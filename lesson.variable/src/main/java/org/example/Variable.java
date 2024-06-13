package org.example;

import java.util.Scanner;

public class Variable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first, second;
        System.out.print("Введите число 1: ");
        first = scanner.nextInt();

        System.out.print("Введите число 2: ");
        second = scanner.nextInt();

        int result = first * second;
        System.out.println(first + " * " + second + " = " + result);


        int a, b, c;
        System.out.print("Введите число a: ");
        a = scanner.nextInt();

        System.out.print("Введите число b: ");
        b = scanner.nextInt();

        c = b;

        b = a;

        a = c;
        System.out.println("Меняем местами получается:");
        System.out.println("a = " + a + " b = " + b);
    }
}
