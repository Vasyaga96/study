package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class HashSets {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    public static void main(String[] args){
        System.out.print("Введите n: ");
        int n = scanner.nextInt();
        HashSet<Integer> setA = generateSets(n);
        System.out.print("Введите m: ");
        int m = scanner.nextInt();
        HashSet<Integer> setB = generateSets(m);
        printSet(setA);
        printSet(setB);
        HashSet<Integer> setIntersection = new HashSet<>(setA);
        setIntersection.retainAll(setB);
        System.out.println("В множествах А и Б одинаково " + setIntersection.size() + " элементов");
        HashSet<Integer> setSubtraction = new HashSet<>(setB);
        setSubtraction.removeAll(setA);
        System.out.print("Элементы множества B которых нету в множестве А: ");
        printSet(setSubtraction);
        int duplicates = n - setA.size();
        System.out.println(duplicates + " дубликатов получилось при заполнении множества A");

    }
    private static HashSet<Integer> generateSets(int size){
        HashSet<Integer> sat = new HashSet<>();
        for (int i = 0; i < size; i++){
            sat.add(random.nextInt(1,9));
        }
        return sat;
    }
    private static void printSet(HashSet<Integer> set){
        for (int x : set) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
