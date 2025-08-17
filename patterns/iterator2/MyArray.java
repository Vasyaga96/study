package org.example.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArray implements MyIterable, Iterable<Integer> {
    private final ArrayList<Integer> list = new ArrayList<>();

    public int get(int index) {
        return list.get(index);
    }

    public void set(int index, int value) {
        list.set(index, value);
    }

    public void add(int value) {
        list.add(value);
    }

    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public MyIterator getIterator() {
        return new MyArrayIterator(list);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyStandardArrayIterator(list);
    }

    private static class MyStandardArrayIterator implements Iterator<Integer> {
        private final ArrayList<Integer> list;
        private int index = 0;

        private MyStandardArrayIterator(ArrayList<Integer> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public Integer next() {
            int result = list.get(index);
            index++;
            return result;
        }
    }

    private static class MyArrayIterator implements MyIterator {
        private final ArrayList<Integer> list;
        private int index = 0;

        private MyArrayIterator(ArrayList<Integer> list) {
            this.list = list;
        }

        @Override
        public boolean isValid() {
            return index < list.size();
        }

        @Override
        public int getValue() {
            return list.get(index);
        }

        @Override
        public void next() {
            index++;
        }
    }
}
