package org.example.patterns.memento;

public class NumberSystem {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public NumberMemento createMemento() {
        return new NumberSnapshot(value);
    }

    public void restore(NumberMemento snapshot) {
        if (snapshot instanceof NumberSnapshot numberSnapshot) {
            value = numberSnapshot.getValue();
        }
    }
}
