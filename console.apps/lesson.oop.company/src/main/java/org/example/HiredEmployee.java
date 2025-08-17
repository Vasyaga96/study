package org.example;

public class HiredEmployee extends Employee {
    private int fixedAmount = 40000;
    public HiredEmployee(String name) {super(name);}

    public void changeFixedAmount(int fixedAmount){
        this.fixedAmount = fixedAmount;
    }
    @Override
    public int calculateSalary(){
        return fixedAmount;
    }
}
