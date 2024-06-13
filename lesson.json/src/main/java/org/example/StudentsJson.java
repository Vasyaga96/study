package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentsJson {
    public static final Scanner scannerInput = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("student.json");

        ArrayList<Student>students = new ArrayList<>();
        System.out.print("Введите имя: ");
        String name = scannerInput.nextLine();
        while (!name.equals("выход")){
            System.out.print("Введите оценку: ");
            int mark = scannerInput.nextInt();
            Student student = new Student(name,mark);
            students.add(student);
            scannerInput.nextLine();
            System.out.print("Введите имя: ");
            name = scannerInput.nextLine();
        }
        objectMapper.writeValue(file, students);

        ArrayList<Student> studentsRead = objectMapper.readValue(file, new TypeReference<>() {});
        System.out.print("Введите имя студента чью оценку хотите узнать: ");
        String searchStudent = scannerInput.nextLine();
        boolean searchStudentNotFound = true;
        for (Student studentX : studentsRead) {
            if (studentX.name.equals(searchStudent)){
                System.out.print("Оценка студента " + searchStudent + " " + studentX.mark);
                searchStudentNotFound = false;
                break;
            }
        }
        if (searchStudentNotFound){
            System.out.print("Студент не найден :(");
        }
    }
}
class Student {
    String name;
    int mark;

    Student() {
    }

    Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }
}
