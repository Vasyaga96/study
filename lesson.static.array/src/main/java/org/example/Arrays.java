package org.example;

import java.util.Random;
import java.util.Scanner;

public class Arrays {
    private static final int ELEMENT_NOT_FOUND = -1;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Введите колличетсво элементов массива: ");
        int n = scanner.nextInt();;
        int[] array = intputArray(n);
        printArray(array);
        System.out.println("сумма: " + sumArray(array));
        System.out.print("Введите колличетсво элементов массива: ");
        int size = scanner.nextInt();
        System.out.print("Введите начальный диапозон рандомных чисел: ");
        int randomStart = scanner.nextInt();
        System.out.print("Введите конечный диапозон рандомных чисел: ");
        int randomEnd = scanner.nextInt();
        printArray(generateRandomArray(size, randomStart, randomEnd));
        System.out.println(MaxPrimeNumber(array));

    }
    private static int MaxPrimeNumber(int[] arr){
        int primeNumber = 0;
        boolean bool = false;
        boolean boolLast = false;
        int maxPrimeNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            for(int j = 2; j < arr[i]; j++){
                if (arr[i] % j == 0){
                    bool = false;
                    break;
                }
                bool = true;
            }
            if (bool || arr[i] == 1){
                boolLast = true;
                primeNumber = arr[i];
                if (primeNumber > maxPrimeNumber){
                    maxPrimeNumber = primeNumber;
                }
            }
        }
        if (boolLast){
            return maxPrimeNumber;
        }else return ELEMENT_NOT_FOUND;
    }

    private static int[] intputArray(int size){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            System.out.print("Введите " + (i + 1) + " число массива ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++ ){
            System.out.println("["+ i + "]" + " = " + array[i]);
        }
    }

    private static int sumArray(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    private static int[] generateRandomArray(int size, int randomStart, int randomEnd){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(randomStart, randomEnd);
        }
        return array;
    }
    private static int findMaxIndex(int[] array) {
        int indexMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[indexMax]) {
                indexMax = i;
            }
        }
        return indexMax;
    }
    private static int findMaxIndexLast(int[] array) {
        int indexMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[indexMax]) {
                indexMax = i;
            }
        }
        return indexMax;
    }
    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    private static int findMinIndex(int[] array) {
        int indexMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[indexMin]) {
                indexMin = i;
            }
        }
        return indexMin;
    }
    private static int maxPrimeNumber(int[] arr) {
        int primeNumber = 0;
        for(int i = 0; i < arr.length; i++){
            if (checkPrimeNumber(arr[i])){
                if (arr[i] >= primeNumber){
                    primeNumber = arr[i];
                }
            }
        }
        if (primeNumber != 0){
            return primeNumber;
        }else return ELEMENT_NOT_FOUND;
    }

    private static boolean checkPrimeNumber(int number) {
        for (int i = 2; i < number; i ++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
