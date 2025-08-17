package org.example.patterns.visitor;

public class RAM {
    private final int amount;

    public RAM(int amount) {
        this.amount = amount;
    }

    public int cost() {
        return amount * 2000;
    }

    public int power() {
        return amount * 2;
    }
}
