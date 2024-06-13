package org.example;

import java.util.Scanner;

public class DichotomyMetod {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean completeSearchNumber = false;
        int start, center, end;
        int[] array = {2,4,5,7};
        start = 0;
        end = array.length - 1;
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        int attempt = 0;
        int index = 0;
        while(!completeSearchNumber && start <= end){
            attempt+=1;
            center = (start + end + 1) / 2;
            if (number > array[center]){
                start = center + 1;
            }else if (number < array[center]){
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
}
