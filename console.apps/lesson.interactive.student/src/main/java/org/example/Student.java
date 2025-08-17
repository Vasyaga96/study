package org.example;

import java.util.HashMap;
import java.util.Map;

public class Student {
    public String lastName;
    public String firstName;
    public String middleName;
    public String group;
    public HashMap<String, Integer> marks = new HashMap<>();;

    Student(){}

    Student(String lastName, String firstName, String middleName, String group){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.group = group;
    }

    void printMe(){
        System.out.println("Фамилия: " + lastName);
        System.out.println("Имя: " + firstName);
        System.out.println("Отчество: " + middleName);
        System.out.println("Группа: " + group);
        System.out.println("Оценки: ");
        if (!marks.isEmpty()){
            for (Map.Entry<String, Integer> entry : marks.entrySet()){
                System.out.println(" " + entry.getKey() + ": " + entry.getValue());
            }
        }else System.out.println("Оценок нет");
    }
}
