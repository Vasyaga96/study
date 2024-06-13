package org.example;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a,b,c;

        System.out.println("Введите число a");
        a = scanner.nextInt();
        System.out.println("Введите число b которое должно быть больше a");
        b = scanner.nextInt();
        System.out.println("Введите число c");
        c = scanner.nextInt();

        if (c > b) {
            System.out.println("Число с больше а и b");
        } else if (c > a && c < b) {
            System.out.println("Число больше а но меньше b");
        } else {
            System.out.println("Число с меньше а и b");
        }
    }
}
