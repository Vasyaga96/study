package org.example;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSortDynamicArray {
    private static final Random random = new Random();
    public static void main(String[] args){
        ArrayList<Integer>dynamicArray = generateRandomDynamicArray(10, 1, 10);
        printDynamicArrayPretty(dynamicArray);
        printDynamicArrayPretty(insertionSortDynamicArray(dynamicArray));
    }
    private static ArrayList<Integer> insertionSortDynamicArray(ArrayList<Integer> dynamicArr){
        for (int i = 1; i < dynamicArr.size(); i++){
            int start = i;
            while (start > 0 && dynamicArr.get(start) < dynamicArr.get(start - 1)){
                int k = dynamicArr.get(start - 1);
                dynamicArr.set(start - 1, dynamicArr.get(start));
                dynamicArr.set(start, k);
                start -= 1;
            }
        }
        return dynamicArr;
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
