package org.example;

import java.util.Random;
import java.util.Scanner;

public class TwoDArrayCompetitions {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    public static void main(String[] args) {
        System.out.print("Введите колличество комманд: ");
        int n = scanner.nextInt();
        System.out.print("Введите колличество соревнований: ");
        int m = scanner.nextInt();
        int[][] competitions = generateStaticArray(n, m, 1, 9);
        printStaticArray(competitions);

        int winner = 0;
        int scoresMax = 0;
        int scoresTeam = 0;
        int[][] rating = new int[n][2];
        for (int i = 0; i < competitions.length; i++){
            for (int j = 0; j < competitions[i].length; j++){
                scoresTeam += competitions[i][j];
            }
            rating[i][0] = i + 1;
            rating[i][1] = scoresTeam;
            if (scoresTeam > scoresMax){
                scoresMax = scoresTeam;
                winner = i + 1;
            }
            scoresTeam = 0;
        }
        System.out.println("Победитель комманда № " + winner + " набрав " + scoresMax + " очков");
        System.out.println("Рейтинг");
        sortBy2Index(rating);
        printStaticArrayRatig(rating);

    }
    public static int[][] sortBy2Index(int[][] array){
        boolean checkSort = false;
        while(!checkSort){
            checkSort = true;
            for (int i = 0; i < array.length - 1; i++){
                if (array[i + 1][1] > array[i][1]){
                    int teamSort = array[i][0];
                    int scoresSort = array[i][1];
                    array[i][0] = array[i + 1][0];
                    array[i][1] = array[i + 1][1];
                    array[i + 1][0] = teamSort;
                    array[i + 1][1] = scoresSort;
                    checkSort = false;
                }
            }
        }
        return array;
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
            System.out.println("Комманда № " + (i + 1) + " ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printStaticArrayRatig(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Комманда № " + (i + 1) + " ");
            for (int j = 1; j < array[i].length; j++) {
                System.out.print("набрала " + array[i][j] + " баллов");
            }
            System.out.println();
        }
    }
}
