package org.example.patterns.visitor;

public class Computer {
    private final Motherboard motherboard = new Motherboard();

    public void accept(ComputerVisitor computerVisitor) {
        motherboard.accept(computerVisitor);
    }
}
