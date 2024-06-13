package org.example;

import java.util.Scanner;

public class Matrix {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Введите n: ");
        int n = scanner.nextInt();
        System.out.println("Введите m: ");
        int m = scanner.nextInt();
        System.out.println("Введите k: ");
        int k = scanner.nextInt();

        int[][]matrixA = TwoDArray.generateStaticArray(n, m, 1,9);
        TwoDArray.printStaticArray(matrixA);
        int[][]matrixB = TwoDArray.generateStaticArray(m, k, 1,9);
        TwoDArray.printStaticArray(matrixB);
        int[][]matrixResult = matrixProduct(matrixA, matrixB);
        TwoDArray.printStaticArray(matrixResult);
    }
    public static int[][] matrixProduct(int[][] matrixA, int[][]matrixB){
        int[][]matrixResult = new int[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++){
            for (int j = 0; j < matrixB[0].length; j++){
                for (int r = 0; r < matrixA[0].length; r++){
                    matrixResult[i][j] += matrixA[i][r] * matrixB[r][j];
                }
            }
        }
        return  matrixResult;
    }
}
