package org.example;

import java.util.Scanner;

public class Diagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер фигуры: ");
        int n = scanner.nextInt();

    }
    private static void diagonal1(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    private static void diagonal2(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i + j == size - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    private static void diagonal3(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || j == (size - 1) - i) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    private static void diagonal4(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i <= j) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    private static void diagonal5(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i >= size - j - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    private static void diagonal6(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i <= j && i >= (size - j) - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    private static void diagonal7(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i >= j && i >= (size - j) - 1){
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    private static void diagonal8(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i <= j && i <= (size - j) - 1) || (i >= j && i >= (size - j) - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    private static void diagonal9(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i <= j && i >= (size - j) - 1) || (i >= j && i <= (size - j) - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
