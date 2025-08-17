package org.example;

import java.util.Scanner;
import java.util.HashMap;

public class Mapa {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        HashMap<String, Integer> reportCard = new HashMap<>();
        int sum = 0;
        System.out.print("Введите фамилию: ");
        String name = scanner.nextLine();
        while (!name.equals("выход")){
            System.out.print("Введите оценку: ");
            int mark = scanner.nextInt();
            scanner.nextLine();
            sum += mark;
            reportCard.put(name, mark);
            System.out.print("Введите фамилию: ");
            name = scanner.nextLine();
        }
        System.out.print("Введите фамилию чью оценку хотите узнать: ");
        String searchName = scanner.nextLine();
        if (reportCard.containsKey(searchName)){
            System.out.println(reportCard.get(searchName));
        }else System.out.println("Такого ученика нету");
        System.out.println("Средний балл учеников: " + (sum / reportCard.size()));
    }
}
