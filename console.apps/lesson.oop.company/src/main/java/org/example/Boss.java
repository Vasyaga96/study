package org.example;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final List<Employee> employee = new ArrayList<>();
    private final List<Task> toDoList = new ArrayList<>();

    private void addTaskInToDoList(Task task) {
        this.toDoList.add(task);
    }
    private boolean haveTasksInToDoList() {
        return !toDoList.isEmpty();
    }
    private boolean haveEmployeeWork(){
        for (Employee employee : employee){
            if (employee.haveTask()){
                return true;
            }
        }
        return false;
    }
    private Employee findFreeEmployee(){
        for (Employee employee: employee){
            if (!employee.haveTask()){
                return employee;
            }
        }
        return null;
    }
    private void giveTaskFreeEmployee(Task task){
        findFreeEmployee().setCurrentTask(task);
    }
    private void giveTaskFreeEmployeeForToDoList(){
        if (haveTasksInToDoList()){
            findFreeEmployee().setCurrentTask(toDoList.getFirst());
            toDoList.removeFirst();
        }
    }
    private void showEmployee() {
        System.out.println("Текущий список работников и их задачи:");
        System.out.println();
        for (Employee employee : employee) {
            employee.showEmployee();
        }
    }
    private void showToDoList(){
        if (haveTasksInToDoList()){
            System.out.println("Отложенные задачи: ");
            for (Task task : toDoList){
                System.out.print(task.getDurationHours() + " ");
            }
            System.out.println();
        }else {
            System.out.println("Отложенных задач нет");
        }

    }
    private boolean haveFreeEmployee(){
        for (Employee employee: employee){
            if (!employee.haveTask()){
                return true;
            }
        }
        return false;
    }
    public void addEmployee(Employee newEmployee) {
        this.employee.add(newEmployee);
    }
    public void showBoss(){
        showEmployee();
        showToDoList();
        System.out.println();
    }
    public void giveTask(Task task){
        if (haveFreeEmployee()){
            giveTaskFreeEmployee(task);
        } else {
            addTaskInToDoList(task);
        }
    }
    public void giveTaskFromToDoList(){
        if (haveFreeEmployee()){
            giveTaskFreeEmployeeForToDoList();
        }
    }
    public boolean GoWork(){
        return (haveTasksInToDoList() || haveEmployeeWork());
    }
    public List<Employee> getEmployee() {
        return employee;
    }

}
