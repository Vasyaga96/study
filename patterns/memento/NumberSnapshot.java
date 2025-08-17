package org.example.patterns.memento;

class NumberSnapshot implements NumberMemento {
    private final int value;

    NumberSnapshot(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
