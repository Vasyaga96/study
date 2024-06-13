package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TwoDimensionalArrays {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.print("Введите количество команд: ");
        int team = scanner.nextInt();
        System.out.print("Введите количество соревнований: ");
        int competitions = scanner.nextInt();
        int[][] array1 = generateStaticArray(team, competitions, 1, 9);
        printStaticArray(array1);
        int sumMax = 0, winner = 0;
        for (int i = 0; i < array1.length; i++) {
            int sum = 0;
            for(int j = 0; j < array1[i].length; j++) {
                sum += array1[i][j];
            }
            if (sum > sumMax) {
                sumMax = sum;
                winner = i + 1;
            }
        }
        System.out.println("Победитель команда № "+ winner + " Набрав " + sumMax + " Очков");

    }

    public static int[][] generateStaticArray(int rows, int cols, int from, int to) {
        int[][] result = new int[rows][cols];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = random.nextInt(from, to);
            }
        }

        return result;
    }
    public static void printStaticArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}