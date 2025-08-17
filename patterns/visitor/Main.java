package org.example.patterns.visitor;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();

        ComputerCostVisitor costVisitor = new ComputerCostVisitor();
        computer.accept(costVisitor);

        ComputerPowerVisitor powerVisitor = new ComputerPowerVisitor();
        computer.accept(powerVisitor);

        System.out.println(costVisitor.getTotalCost());
        System.out.println(powerVisitor.getPower());
    }
}
