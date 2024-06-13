package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DinamycArray {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<>();
        inputDinamycArray(array);
        printDinamycArray(array);
        System.out.println(product(array));
    }
    private static ArrayList<Integer> inputDinamycArray(ArrayList<Integer> array){
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        int i = 0;
        while (number != 0){
            array.add(i, number);
            System.out.print("Введите число: ");
            number = scanner.nextInt();
            i++;
        }
        return array;
    }
    private static void printDinamycArray(ArrayList<Integer> array){
        for (int item : array){
            System.out.print(item);
        }
        System.out.println();
    }
    private static int product(ArrayList<Integer> array){
        int product = 1;
        for (int i = 0; i < array.size();i++){
            product *= array.get(i);
        }
        return product;
    }
}
