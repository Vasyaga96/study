package org.example;

abstract class Student {
    private String name;
    private String gender;

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public abstract boolean passTest();
}
