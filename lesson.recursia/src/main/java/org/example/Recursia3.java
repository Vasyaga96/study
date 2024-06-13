package org.example;

import java.util.Scanner;

public class Recursia3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        System.out.println(revRec(n));
    }

    private static int revRec(int n) {
        return revRecReal(n, 0);
    }

    private static int revRecReal(int head, int tail) {
        if (head == 0) return tail;

        return revRecReal(
                head / 10,
                tail * 10 + head % 10
        );
    }
}
