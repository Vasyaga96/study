package org.example;

import java.util.Scanner;

public class clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Введите положительное число: ");
        n = scanner.nextInt();

        while (n <= 0 || n % 2 == 0) {
            System.out.println("Вы ввели некорректное значение! Введите положительное число: ");
            n = scanner.nextInt();
        }
        int k = 0;
        for (int i = n; i > 0; i -= 2) {
            for (int z = 0; z < k; z++) {
                System.out.print(" ");
            }
            k += 1;
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        k = 0;
        for (int i = 2; i <= n; i += 2) {
            for (int z = k; z >= 0; z--) {
                System.out.print(" ");
            }
            k -= 1;
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}