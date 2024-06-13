package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentClass {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        String lastName, firstName, middleName;
        int mark;
        System.out.print("Введите фамилию: ");
        lastName = scanner.nextLine();
        while(!lastName.equals("выход")) {
            System.out.print("Введите имя: ");
            firstName = scanner.nextLine();
            System.out.print("Введите отчество: ");
            middleName = scanner.nextLine();
            System.out.print("Введите оценку: ");
            mark = scanner.nextInt();
            Student student = new Student(lastName,firstName,middleName,mark);
            students.add(student);
            scanner.nextLine();
            System.out.print("Введите фамилию: ");
            lastName = scanner.nextLine();
        }
        System.out.print("Введите фамилию чью оценку хотите узнать: ");
        String searchName = scanner.nextLine();
        boolean studentNotFound = true;
        int sum = 0;
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).lastName.equals(searchName)){
                System.out.println("Оценка студента " + students.get(i).lastName + " " + students.get(i).mark);
                studentNotFound = false;
            }
            sum += students.get(i).mark;
        }
        if (studentNotFound){
            System.out.println("Такого студента нету =(");
        }else System.out.printf("Средний балл группы, %.1f", (double)sum / students.size());
    }
    private static Student createStudent(
            String lastName,
            String firstName,
            String middleName,
            int mark
    ) {
        Student result = new Student();
        result.lastName = lastName;
        result.firstName = firstName;
        result.middleName = middleName;
        result.mark = mark;

        return result;
    }
}

class Student {
    String lastName;     // поле
    String firstName;
    String middleName;
    int mark;

    Student() {}

    // конструктор
    Student(String lastName, String firstName, String middleName, int mark) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.mark = mark;
    }

    String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    // геттер
    public int getMark() {
        return mark;
    }

    // сеттер
    void setMark(int mark) {
        if (mark >= 2 && mark <= 5) {
            this.mark = mark;
        }
    }

    // метод
    void printMe() {
        System.out.println("Фамилия: " + lastName);
        System.out.println("Имя: " + firstName);
        System.out.println("Отчество: " + middleName);
        System.out.println("Оценка: " + mark);
    }
}