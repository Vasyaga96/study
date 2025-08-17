package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String lastName;
    private String firstName;
    private String surname;
    private String group;
    private HashMap<String, Integer> marks = new HashMap<>();

    public Student(String lastName, String firstName, String surname, String group){
        this.lastName = lastName;
        this.firstName = firstName;
        this.surname = surname;
        this.group = group;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName(){
        return lastName + " " + firstName + " " + surname;
    }

    public String getGroup() {
        return group;
    }

    public HashMap<String, Integer> getMarks() {
        return marks;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void showStudent(){
        System.out.println("Фамилия: " + lastName);
        System.out.println("Имя: " + firstName);
        System.out.println("Отчество: " + surname);
        System.out.println("Группа: " + group);
        System.out.println("Оценки: ");
        if (!marks.isEmpty()){
            for (Map.Entry<String, Integer> entry : marks .entrySet()){
                System.out.println("    " + entry.getKey() + ": " + entry.getValue());
            }
        }else System.out.println("  Оценок нет");
    }
    public void addMark(String subject, int mark){
        this.marks.put(subject, mark);
    }
    public void deleteMark(String subject){
        marks.remove(subject);
    }

}
