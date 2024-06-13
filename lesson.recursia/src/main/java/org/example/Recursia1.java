package org.example;

import java.util.Scanner;

public class Recursia1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        reс(n);
    }
    private static void reс(int n) {
        if (n >= 0 && n < 10) {
            System.out.print((n + 1) % 10);
            return;
        }
        // прямой ход рекурсии vvvvv

        // 123 -> 12 и 3 -> напечатать 3 и перевернуть 12


        // ^^^^^ прямой ход рекурсии
        reс(n / 10);

        // обратный ход рекурсии vvvvv
        System.out.print((n % 10 + 1) % 10);
        // ^^^^^ обратный ход рекурсии
    }
}
