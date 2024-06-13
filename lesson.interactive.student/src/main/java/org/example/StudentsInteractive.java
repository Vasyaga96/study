package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentsInteractive {
    public static final Scanner scannerInput = new Scanner(System.in);
    public static ArrayList<Student> students = new ArrayList<>();
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final File file = new File("student.json");
    public static void main(String[] args) throws Exception {
        if (!file.exists()){
            students = objectMapper.readValue(file, new TypeReference<>() {});
        }
        boolean menu = true;
        while (menu){
            int selectedMenu = selectedMenu();
            menu = menu(selectedMenu);
        }
    }
    public static int selectedMenu (){
        printMenu();
        int selectedMenu = scannerInput.nextInt();
        System.out.println();
        while (selectedMenu < 1 || selectedMenu > 7){
            printMenu();
            selectedMenu = scannerInput.nextInt();
            System.out.println();
        }
        return selectedMenu;
    }
    public static boolean menu(int selectedMenu) throws Exception{
        if (selectedMenu < 1 || selectedMenu > 7){
            System.out.println("Вы выбрали не существующий пункт меню, попробуйте еще раз: ");
        }else if (selectedMenu == 1){
            printStudents();
        } else if (selectedMenu == 2) {
            newStudentAdd();
            objectMapper.writeValue(file, students);
        } else if (selectedMenu == 3) {
            editStudent();
        } else if (selectedMenu == 4) {
            deleteStudent();
            objectMapper.writeValue(file, students);
        } else if (selectedMenu == 5){
            showExcellent();
        } else if (selectedMenu == 6){
            showLosers();
        } else return false;
        return true;
    }
    public static void printStudents(){
        if (students.isEmpty()) {
            System.out.println("Студентов нету");
            return;
        }
        for (int i = 0; i < students.size();i++){
            System.out.print("=== " + (i + 1) + " ===");
            System.out.println();
            students.get(i).printMe();
        }
    }
    public static void simplePrintStudents(){
        for (int i = 0; i < students.size();i++){
            Student editStudent = students.get(i);
            System.out.println((i+1) +  ". " + editStudent.lastName + " " + editStudent.firstName + " " +
                    editStudent.middleName + " (" + editStudent.group + ")");
        }
    }
    public static String studentInput(String prompt){
        System.out.print("Введите " + prompt);
        return scannerInput.next();
    }
    public static void newStudentAdd(){
        String newLastName = studentInput("фамилию: ");
        String newFirstName = studentInput("имя: ");
        String newMiddleName = studentInput("отчество: ");
        String newGroup = studentInput("группу: ");
        System.out.println();
        Student newStudent = new Student(newLastName, newFirstName, newMiddleName, newGroup);
        System.out.println("Вы создали нового студента");
        System.out.println();
        newStudent.printMe();
        students.add(newStudent);
    }
    public static int selectedEditMenu(){
        editMenu();
        int selectedEditMenu = scannerInput.nextInt();
        System.out.println();
        return selectedEditMenu;
    }
    public static void editStudent() throws Exception{
        simplePrintStudents();
        System.out.print("Какого студента хотите редактировать? ");
        Student editStudent = students.get(scannerInput.nextInt() - 1);
        System.out.println();
        System.out.println("Редактируемый студент: ");
        editStudent.printMe();
        int selectedEditMenu = selectedEditMenu();
        while (selectedEditMenu != 8){
            if (selectedEditMenu == 1){
                editStudent.lastName = studentInput("Новая фамилия: ");
                objectMapper.writeValue(file, students);
            } else if (selectedEditMenu == 2) {
                editStudent.firstName = studentInput("Новое имя: ");
                objectMapper.writeValue(file, students);
            } else if (selectedEditMenu == 3) {
                editStudent.middleName = studentInput("Новое отчество: ");
                objectMapper.writeValue(file, students);
            } else if (selectedEditMenu == 4) {
                editStudent.group = studentInput("Новая группа: ");
                objectMapper.writeValue(file, students);
            } else if (selectedEditMenu == 5) {
                newMark(editStudent);
                objectMapper.writeValue(file, students);
            } else if (selectedEditMenu == 6) {
                editMark(editStudent);
                objectMapper.writeValue(file, students);
            } else if (selectedEditMenu == 7){
                deleteMark(editStudent);
                objectMapper.writeValue(file, students);
            }
            selectedEditMenu = selectedEditMenu();
        }
    }
    public static void newMark(Student student){
        System.out.print("Предмет: ");
        String newLesson = scannerInput.next();
        System.out.print("Оценку: ");
        int newMark = scannerInput.nextInt();
        student.marks.put(newLesson, newMark);
    }
    public static void editMark(Student student){
        System.out.print("Предмет: ");
        String editLesson = scannerInput.next();
        if (!student.marks.containsKey(editLesson)){
            System.out.println("Предмета " + editLesson + " нету");
        }else {
            System.out.print("Оценка: ");
            int editNewMark = scannerInput.nextInt();
            student.marks.put(editLesson, editNewMark);
        }
    }
    public static void deleteMark(Student student){
        System.out.print("Предмет: ");
        String deleteMark = scannerInput.next();
        if(!student.marks.containsKey(deleteMark)){
            System.out.println("Предмета " + deleteMark + " нету");
        }else {
            System.out.print("Вы уверенны что хотите удалить оценку по предмету " + deleteMark +
                    "? y/n: ");
            String proofDeleteMark = scannerInput.next();
            if (proofDeleteMark.equals("y")){
                student.marks.remove(deleteMark);
                System.out.println("Оценка удалена");
            }
        }
    }
    public static void deleteStudent(){
        simplePrintStudents();
        System.out.print("Номер студента для удаления: ");
        int numDeleteStudent = scannerInput.nextInt();
        Student deleteStudent = students.get(numDeleteStudent - 1);
        System.out.print("Вы уверенны что хотите удалить студента " + deleteStudent.lastName + " " +
                deleteStudent.middleName + " " + " (" + deleteStudent.group + ")? + [y/n]: ");
        String proofDeleteStudent = scannerInput.next();
        if (proofDeleteStudent.equals("y")){
            System.out.println("Студент удален");
            System.out.println();
            students.remove(numDeleteStudent - 1);
        }
    }
    public static void showExcellent(){
        boolean excellentIsNotFound = true;
        for (Student student : students){
            boolean excellent = true;
            if (!student.marks.isEmpty() && !students.isEmpty()){
                for (int mark : student.marks.values()){
                    if (mark < 5){
                        excellent = false;
                    }
                }
                if (excellent){
                    student.printMe();
                    excellentIsNotFound = false;
                }
            }
        }
        if (excellentIsNotFound){
            System.out.println("Отличников нет");
            System.out.println();
        }
    }
    public static void showLosers(){
        boolean loserIsNotFound = true;
        for (Student student : students){
            boolean loser = false;
            if (!student.marks.isEmpty() && !students.isEmpty()){
                for (int mark: student.marks.values()){
                    if (mark < 3){
                        loser = true;
                    }
                }
                if (loser){
                    student.printMe();
                    loserIsNotFound = false;
                }
            }
        }
        if (loserIsNotFound){
            System.out.println("Неуспевающих нет");
            System.out.println();
        }
    }
    public static void editMenu(){
        System.out.println();
        System.out.println("1. Изменить фамилию");
        System.out.println("2. Изменить имя");
        System.out.println("3. Изменить отчество");
        System.out.println("4. Изменить группу");
        System.out.println("5. Добавить оценку");
        System.out.println("6. Изменить оценку");
        System.out.println("7. Удалить оценку");
        System.out.println("8. Назад");
        System.out.print("Выберите пункт меню: ");
    }
    public static void printMenu(){
        System.out.println("1.Список студентов");
        System.out.println("2.Добавить студента");
        System.out.println("3.Редактировать студента");
        System.out.println("4.Удалить студента");
        System.out.println("5.Показать отличников");
        System.out.println("6.Показать неуспевающих");
        System.out.println("7.Выход");
        System.out.print("Выберите пункт меню: ");
    }
}
