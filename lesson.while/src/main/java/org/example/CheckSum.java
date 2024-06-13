package org.example;

import java.util.Scanner;

public class CheckSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Введите положительное число n: ");
        n = scanner.nextInt();
        int addend;
        int sum = 0;

        while (sum <= n) {
            System.out.print("Введите число: ");
            addend = scanner.nextInt();
            sum += addend;
        }
        System.out.println(sum);
    }
}
