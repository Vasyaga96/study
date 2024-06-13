package org.example;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class BinaryStudent  {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        String name;
        byte mark;
        System.out.print("Введите имя: ");
        name = scanner.nextLine();
        while(!name.equals("выход")) {
            System.out.print("Введите оценку: ");
            mark = scanner.nextByte();
            Student student = new Student(name,mark);
            students.add(student);
            scanner.nextLine();
            System.out.print("Введите имя: ");
            name = scanner.nextLine();
        }
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("data.bin"))){
            short countSize = (short) students.size();
            ByteBuffer buffer = ByteBuffer.allocate(2);
            buffer.putShort(countSize);
            byte[] data = buffer.array();
            stream.write(data);
            for (int i = 0; i < students.size(); i++){
                Student student = students.get(i);
                name = student.name;
                mark = student.mark;
                byte[] nameBytes = name.getBytes();
                buffer = ByteBuffer.allocate(2 + nameBytes.length + 1);
                buffer.putShort((short) nameBytes.length);
                buffer.put(nameBytes);
                buffer.put(mark);
                data = buffer.array();
                stream.write(data);
            }
        }
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream("data.bin"))){
            ArrayList<Student> studentsRead = new ArrayList<>();
            byte[] countSize = new byte[2];
            stream.read(countSize);
            short count = ByteBuffer.wrap(countSize).getShort();
            byte[] nameSizeByte = new byte[2];
            for (short i = 0; i < count; i++) {
                stream.read(nameSizeByte);
                short nameSize = ByteBuffer.wrap(nameSizeByte).getShort();

                byte[] nameByte = new byte[nameSize];
                stream.read(nameByte);
                String name1 = new String(nameByte);
                byte mark1 = (byte) stream.read();

                Student studentRead = new Student(name1, mark1);
                studentsRead.add(studentRead);
            }
        }
        System.out.print("Введите фамилию ученика чью оценку хотите узнать: ");
        String studentSearch = scanner.nextLine();
        boolean studentSearchNotFount = true;
        for(Student studentX : students){
            if (studentX.name.equals(studentSearch)){
                System.out.print("Оценка студента " + studentSearch + " " + studentX.mark);
                studentSearchNotFount = false;
                break;
            }
        }
        if (studentSearchNotFount){
            System.out.print("Студент не найден :(");
        }
    }
}
class Student {
    public String name;     // поле
    public byte mark;

    Student() {
    }

    Student(String lastName, byte mark) {
        this.name = lastName;
        this.mark = mark;
    }
}