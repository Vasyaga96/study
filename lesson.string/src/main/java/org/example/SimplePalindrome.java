package org.example;

import java.util.Scanner;

public class SimplePalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = scanner.nextLine();

        boolean isPalindrome = true;

        // а роза упала на лапу азора

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == ' ') {
                start += 1;
                if (s.charAt(end) == ' ') {
                    end -= 1;
                }
                if (s.charAt(start) != s.charAt(end)) {
                    isPalindrome = false;
                    break;
                } else {
                    start += 1;
                    end -= 1;
                }
            }
        }
        if (isPalindrome) {
            System.out.println("Палиндром");
        } else {
            System.out.println("Не палиндром");
        }
    }
}