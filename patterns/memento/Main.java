package org.example.patterns.memento;

public class Main {
    public static void main(String[] args) {
        NumberCaretaker caretaker = new NumberCaretaker();
        NumberSystem system = new NumberSystem();

        system.increment();
        system.increment();

        System.out.println(system.getValue());   // 2

        NumberMemento memento = system.createMemento();
        int index = caretaker.addSnapshot(memento);

        system.decrement();

        System.out.println(system.getValue());   // 1

        NumberMemento savedCopy = caretaker.getSnapshot(index);
        system.restore(savedCopy);

        System.out.println(system.getValue());  // 2
    }
}
