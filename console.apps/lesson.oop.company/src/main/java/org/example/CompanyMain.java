package org.example;

import java.util.List;

public class CompanyMain {
    public static void main(String[] args) {
        Boss boss = new Boss();
        HiredEmployee vasiliy = new HiredEmployee("Вася");
        boss.addEmployee(vasiliy);
        HiredEmployee victor = new HiredEmployee("Виктор");
        boss.addEmployee(victor);
        Contractor nikita = new Contractor("Никита");
        boss.addEmployee(nikita);
        boss.showBoss();
        for (int i = 0; i < 100; i++){
            simulation(1, boss.getEmployee());
            Task task = Task.ctreateRandomTask(1, 5);
            boss.giveTask(task);
            boss.showBoss();
        }
        while (boss.GoWork()){
            boss.giveTaskFromToDoList();
            simulation(1, boss.getEmployee());
            boss.showBoss();
        }
    }
    public static void simulation(int hours, List<Employee> employeeList){
        for (Employee employee : employeeList){
            if (employee.haveTask()){
                int durationHours = employee.getCurrentTask().getDurationHours() - hours;
                employee.getCurrentTask().setDurationHours(durationHours);
                int timeSpent = employee.getTimeSpent() + hours;
                employee.setTimeSpent(timeSpent);
            }
        }
    }
}
