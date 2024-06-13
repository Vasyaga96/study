package org.example;

import java.util.Scanner;
public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w,h,x1,y1,x2,y2;
        System.out.println("Введите высоту h ");
        h = scanner.nextInt();
        System.out.println("Введите ширину w");
        w = scanner.nextInt();
        System.out.println("Введите центральную точку по оси X");
        x1 = scanner.nextInt();
        System.out.println("Введите центральную точку по оси Y");
        y1 = scanner.nextInt();
        System.out.println("Введите точку x2");
        x2 = scanner.nextInt();
        System.out.println("Введите точку y2");
        y2 = scanner.nextInt();

        if (x2 > x1 - w / 2 && x2 < x1 + w / 2 && y2 < y1 + h / 2 && y1 > y2 - h / 2 ) {
            System.out.println("Точка попала в прямоугольник");
        } else if (x2 < x1 - w / 2 || x2 > x1 + w / 2 || y2 > y1 + h / 2 || y1 < y2 - h / 2) {
            System.out.println("Точка не попала в прямоугольник");
        } else {
            System.out.println("Точка на границе");
        }
    }
}
