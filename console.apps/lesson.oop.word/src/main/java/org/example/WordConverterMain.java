package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordConverterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String allWord = scanner.nextLine();

        List<String> words = new ArrayList<>();

        for(String word : allWord.split(" ")){
            words.add(word);
        }

        WordConverter evenConverter = new EvenWordConverter();
        WordConverter oddConverter = new OddWordConverter();

        WordConverter[] converters = new WordConverter[]{
                evenConverter,  // 0
                oddConverter     // 1
        };

        for (int i = 0; i < words.size(); i++) {
            String word = converters[i % 2].convert(words.get(i));
            System.out.println(word);
        }
    }
}
