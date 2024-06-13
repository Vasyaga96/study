package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TwoDArray {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        //
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

    public static ArrayList<ArrayList<Integer>> generateDynamicArray(int rows, int cols, int from, int to) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(random.nextInt(from, to));
            }
            result.add(row);
        }

        return result;
    }

    public static int[][] inputStaticArray(int rows, int cols) {
        int[][] result = new int[rows][cols];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print("[" + i + "][" + j + "] = ");
                result[i][j] = scanner.nextInt();
            }
        }

        return result;
    }

    public static ArrayList<ArrayList<Integer>> inputDynamicArray(int rows, int cols) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                System.out.print("[" + i + "][" + j + "] = ");
                row.add(scanner.nextInt());
            }

            result.add(row);
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

    public static void printDynamicArray(ArrayList<ArrayList<Integer>> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.get(i).size(); j++) {
                System.out.print(array.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}