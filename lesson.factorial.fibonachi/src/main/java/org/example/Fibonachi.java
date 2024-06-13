package org.example;

import java.util.Scanner;

public class Fibonachi {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        System.out.println(fibonachiFor(n));
        System.out.println(fibonachiWhile(n));
        System.out.println(fibonachiDoWhile(n));
    }
    public static int fibonachiFor(int n){
        int fib1,fib2, k = 0;
        fib1 = 1;
        fib2 = 1;
        for (int i=3;i<=n;i++){
            k = fib1 + fib2;
            fib1 = fib2;
            fib2 = k;
        }
        return k;
    }

    public static int fibonachiWhile(int n){
        int fib1,fib2, k = 0, i = 3;
        fib1 = 1;
        fib2 = 1;
        while (i <=n){
            i++;
            k = fib1 + fib2;
            fib1 = fib2;
            fib2 = k;
        }
        return k;
    }

    public static int fibonachiDoWhile(int n){
        int fib1,fib2, k = 0, i = 3;
        fib1 = 1;
        fib2 = 1;
        do {
            i++;
            k = fib1 + fib2;
            fib1 = fib2;
            fib2 = k;
        }while (i <= n);
        return k;
    }
}
