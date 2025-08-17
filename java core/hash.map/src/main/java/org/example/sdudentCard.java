package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class sdudentCard {
    public static final String LAST_NAME = "Фамилия";
    public static final String FIRST_NAME = "Имя";
    public static final String MIDDLE_NAME = "Отчество";
    public static final String MARK = "Оценка";
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<HashMap<String, Object>> students = new ArrayList<>();
        HashMap<String, Object> student = new HashMap<>();
        String lastName, firstName,middleName;
        int mark;
        System.out.print("Введите фамилию студента: ");
        lastName = scanner.nextLine();
        while(!lastName.equals("выход")) {
            System.out.print("Введите имя: ");
            firstName = scanner.nextLine();
            System.out.print("Введите отчество: ");
            middleName = scanner.nextLine();
            System.out.print("Введите оценку: ");
            mark = scanner.nextInt();
            student = createStudent(lastName,firstName,middleName,mark);
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
            if (students.get(i).get(LAST_NAME).equals(searchName)){
                System.out.println("Оценка студента " + students.get(i).get(LAST_NAME) + " " + students.get(i).get(MARK));
                studentNotFound = false;
            }
            sum += (int)students.get(i).get(MARK);
        }
        if (studentNotFound){
            System.out.println("Такого студента нету =(");
        }else System.out.printf("Средний балл группы, %.1f", (double)sum / students.size());

    }
    private static HashMap<String, Object> createStudent(
            String lastName,
            String firstName,
            String middleName,
            int mark
    ) {
        HashMap<String, Object> result = new HashMap<>();
        result.put(LAST_NAME, lastName);
        result.put(FIRST_NAME, firstName);
        result.put(MIDDLE_NAME, middleName);
        result.put(MARK, mark);

        return result;
    }
    private static void printStudent(HashMap<String, Object> student) {
        System.out.println("Фамилия: " + student.get(LAST_NAME));
        System.out.println("Имя: " + student.get(FIRST_NAME));
        System.out.println("Отчество: " + student.get(MIDDLE_NAME));
        System.out.println("Оценка: " + student.get(MARK));
    }
}
