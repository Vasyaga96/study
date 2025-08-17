package org.example.patterns.iterator;

import java.util.Iterator;

public class MyLinkedList implements MyIterable, Iterable<Integer> {
    private Node root = null;

    public int getFirst() {
        if (root == null) {
            throw new IllegalStateException("List is empty");
        }

        return root.getValue();
    }

    public void add(int value) {
        root = new Node(value, root);
    }

    public void remove(int value) {
        if (root != null && root.getValue() == value) {
            root = root.getNext();
            return;
        }

        Node current = root;

        while (current != null && current.getNext() != null) {
            Node next = current.getNext();
            if (next.getValue() == value) {
                current.setNext(next.getNext());
                return;
            }
        }
    }

    @Override
    public MyIterator getIterator() {
        return new MyLinkedListIterator(root);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyStandardLinkedListIterator(root);
    }

    private static class MyStandardLinkedListIterator implements Iterator<Integer> {
        private Node current;

        private MyStandardLinkedListIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            int result = current.getValue();
            current = current.getNext();
            return result;
        }
    }

    private static class MyLinkedListIterator implements MyIterator {
        private Node current;

        private MyLinkedListIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean isValid() {
            return current != null;
        }

        @Override
        public int getValue() {
            return current.getValue();
        }

        @Override
        public void next() {
            current = current.getNext();
        }
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
