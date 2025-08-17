package org.example.patterns.visitor;

public class Disk {
    public final int capacity;

    public Disk(int capacity) {
        this.capacity = capacity;
    }

    public int cost() {
        return capacity * 500;
    }

    public int power() {
        return capacity / 4;
    }
}
