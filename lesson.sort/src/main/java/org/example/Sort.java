package org.example;

public class Sort {
    public static void main(String[] args) {
        int[] array = {2,5,3,4,6,1};
        printArray(array);

        printArray(insertionSort(array));
    }

    private static int[] insertionSort(int[] array){
        for (int i = 1; i < array.length;i++){
            boolean checkSort = false;
            int start = i;
            while(start > 0 && !checkSort){
                checkSort = true;
                if (array[start] < array[start - 1]){
                    int k = array[start - 1];
                    array[start - 1] = array[start];
                    array[start] = k;
                    checkSort = false;
                    start -= 1;
                }
            }
        }
        return array;
    }
    private static int[] bubbleSort(int [] array){
        boolean checkSort = false;
        while(!checkSort){
            checkSort = true;
            for (int i = 0; i < array.length - 1; i++){
                if (array[i + 1] < array[i]){
                    int k = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = k;
                    checkSort = false;
                }
            }
        }
        return array;
    }
    private static int[] selectionSort(int[] array){
        for (int i = 0; i < array.length;i++) {
            int start = 0;
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] <= array[min]) {
                    min = j;
                }
            }
            start = array[i];
            array[i] = array[min];
            array[min] = start;
        }
        return array;
    }
    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++ ){
            System.out.print("["+ array[i] + "]");
        }
        System.out.println();
    }
}
