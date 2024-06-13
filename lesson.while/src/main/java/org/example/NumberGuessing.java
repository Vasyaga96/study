package org.example;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        int x = random.nextInt(20, 100);
        int n;
        int attempts = 0;
        System.err.println(x);
        do {
            System.out.print("Попробуйте угадать число которое я загадал: ");
            n = scanner.nextInt();
            if (n > x){
                System.out.println("Мое число меньше");
            } else if ( n < x) {
                System.out.println("Мое число больше");
            }
            attempts ++;
        } while (n != x);
        System.out.println("Поздравляю вас, вы угадали это число: " + n);
        System.out.println("Колличество попыток: " + attempts);
    }
}
