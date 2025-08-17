package org.example;

public class Contractor extends Employee{
    private int paymentPerHour = 150;
    public Contractor(String name){super(name);}

    @Override
    public int calculateSalary(){
        return paymentPerHour * getTimeSpent();
    }
}
