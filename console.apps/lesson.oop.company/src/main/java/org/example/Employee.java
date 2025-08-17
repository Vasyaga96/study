package org.example;

public abstract class Employee {
    private final String name;
    private int timeSpent;
    private Task currentTask = new Task(0);

    public Employee(String name){
        this.name = name;
    }
    public void showEmployee(){
        System.out.println("Имя: " + name);
        if (currentTask.haveDurationHours()){
            System.out.println("Текущая задача: " + currentTask.getDurationHours() + " часов");
        }else {
            System.out.println("Задач нету");
        }
        System.out.println();
    }
    public boolean haveTask(){
        return currentTask.haveDurationHours();
    }
    public Task getCurrentTask() {
        return currentTask;
    }
    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }
    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }
    public int getTimeSpent() {
        return timeSpent;
    }
    public abstract int calculateSalary();
}
