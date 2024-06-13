package org.example;

import java.util.Scanner;

public class string {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Введите строку: ");
        String str = scanner.nextLine();
        System.out.print("Введите символ: ");
        char ch = scanner.next().charAt(0);
        boolean checkCh = false;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)){
                index = i;
                checkCh = true;
                break;
            }
        }
        if (checkCh) System.out.println("Ваш символ найден под индексом " + index);
        else System.out.println("Ваш символ не найден");
    }
}
