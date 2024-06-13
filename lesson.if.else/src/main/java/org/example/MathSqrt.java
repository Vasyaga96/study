package org.example;

import java.util.Scanner;

public class MathSqrt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a,b,c,x1,x2,discriminant;

        System.out.println("Введите число a");
        a = scanner.nextInt();
        System.out.println("Введите число b");
        b = scanner.nextInt();
        System.out.println("Введите число c");

        c = scanner.nextInt();
        discriminant = b*b - 4*a*c;
        if (a == 0 && b == 0) {
            System.out.println("Корнем может быть любое число");
        } else if (a == 0 ) {
            x1 = -c / b;
            System.out.println("У уравнения 1 корень. x = " + x1);
        } else if (discriminant > 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("У уравнения 2 корня. х1 = " + x1 + " x2 = " + x2);
        }   else if (discriminant == 0) {
            x1 = -b / (2 * a);
            System.out.println("У уравнения 1 корень. x = " + x1);
        }   else {
            System.out.println("У уравнения нету корней");
        }
    }
}
