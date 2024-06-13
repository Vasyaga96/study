package org.example;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) throws Exception {
        File file = new File("test.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое положительное число: ");
        int n = scanner.nextInt();
        try (PrintWriter out = new PrintWriter(file)) {
            for (int i = 1; i <= n; i++ ) {
                out.print(i + " ");
            }
        }
        Scanner scanner1 = new Scanner(file);
        while (scanner1.hasNextInt()) {
            int num = scanner1.nextInt();
            int doubledNum = num * 2;
            System.out.println(doubledNum + " ");
        }
        scanner.close();
    }
}