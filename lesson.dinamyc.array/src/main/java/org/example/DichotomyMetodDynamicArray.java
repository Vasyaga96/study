package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class DichotomyMetodDynamicArray {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        boolean completeSearchNumber = false;
        int start, center, end;
        ArrayList<Integer> array = generateRandomDynamicArray(10,1,10);
        printDynamicArrayPretty(array);
        Collections.sort(array);
        printDynamicArrayPretty(array);
        start = 0;
        end = array.size() - 1;
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        int attempt = 0;
        int index = 0;
        while(!completeSearchNumber && start <= end){
            attempt+=1;
            center = (start + end + 1) / 2;
            if (number > array.get(center)){
                start = center + 1;
            }else if (number < array.get(center)){
                end = center - 1;
            }else{
                completeSearchNumber = true;
                index = center;
            }
        }
        if (completeSearchNumber){
            System.out.println("Нашли число за " + attempt + " попыток" + " индекс " + index);
        } else{
            System.out.println("Число не найдено");
        }
    }
    public static ArrayList<Integer> generateRandomDynamicArray(int size, int from, int to) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(from, to + 1));
        }

        return result;
    }
    public static void printDynamicArrayPretty(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }
}
