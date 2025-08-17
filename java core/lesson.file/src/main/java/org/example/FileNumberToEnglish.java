package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileNumberToEnglish {
    private static  final Scanner scannerInput = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.print("Введите целое положительне число: ");
        int n = scannerInput.nextInt();
        scannerInput.nextLine();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"))){
            for (int i = 1; i <= n; i++){
                writer.write("" + i);
                if (i < n){
                    writer.write(" ");
                }
            }
        }
        try(BufferedReader reader = new BufferedReader(new FileReader("test.txt"))){
            String line = reader.readLine();
            String[] numbersStr = line.split(" ");
            for (String numberStr : numbersStr){
                long number = Long.parseLong(numberStr);
                System.out.print(numberToEnglish(number) + " ");
            }
        }
    }
    public static String numberToEnglish(long number) {
        String[] ones = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] teens = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] orders = new String[]{"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion"};
        String hundred = "hundred";
        String zero = "zero";
        String minus = "minus";

        boolean isNegative = false;
        if (number < 0) {
            isNegative = true;
            number = -number;
        }

        String result = "";

        if (number == 0) {
            return zero;
        }

        int orderCount = 0;

        while (number > 0) {
            int three = (int) number % 1000;
            number /= 1000;

            // 123
            int onesValue = three % 10;        // 3
            int tensValue = three / 10 % 10;   // 2
            int hundredsValue = three / 100;   // 1

            String threeResult = "";

            if (hundredsValue != 0) {
                threeResult += ones[hundredsValue] + " " + hundred;
            }

            if (tensValue == 1) {
                if (!threeResult.isEmpty()) threeResult += " ";

                threeResult += teens[onesValue];
            } else if (tensValue > 1) {
                if (!threeResult.isEmpty()) threeResult += " ";

                threeResult += tens[tensValue];
            }

            if (tensValue != 1 && onesValue != 0) {
                if (!threeResult.isEmpty()) threeResult += " ";

                threeResult += ones[onesValue];
            }

            if (!threeResult.isEmpty()) {
                threeResult += " " + orders[orderCount];

                result = threeResult + " " + result;
            }

            orderCount++;
        }

        if (isNegative) {
            result = minus + " " + result;
        }

        return result.trim();
    }
}
