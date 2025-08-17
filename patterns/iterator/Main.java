package org.example.patterns.iterator;

public class Main {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        MyLinkedList list = new MyLinkedList();

        array.add(1);
        array.add(2);
        array.add(3);  // [1, 2, 3]

        list.add(3);
        list.add(2);
        list.add(1);  // [1, 2, 3]

        printCollection(array);
        System.out.println("---");
        printCollection(list);
    }

    public static void printCollection(Iterable<Integer> collection) {
//        Iterator<Integer> iterator = collection.iterator();
//
//        while (iterator.hasNext()) {
//            int value = iterator.next();
//            System.out.println(value);
//        }

        for (int value : collection) {
            System.out.println(value);
        }
    }
}
