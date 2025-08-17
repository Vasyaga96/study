package org.example;

import java.util.Scanner;

public class NumToEnglish {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите число: ");
        long number = scanner.nextLong();

        String result = numberToEnglish(number);

        System.out.println("\"" + result + "\"");
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