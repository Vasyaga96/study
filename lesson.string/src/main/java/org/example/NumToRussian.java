package org.example;

import java.util.Scanner;

public class NumToRussian {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите число: ");
        long number = scanner.nextLong();

        String result = numberToRussian(number);
        System.out.println(result);
    }
    public static String numberToRussian(long number){
        String[] ones = new String[]{"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        String[] tens = new String[]{"", "", "двадцать", "дридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "веосемьдесят", "девяносто"};
        String[] teens = new String[]{"десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "пятьнадцать", "шестнадцать", "семьнадцать", "восемьнадцать", "девятьнадцать"};
        String[] hundred = new String[]{"", "сто","двести","триста","четыресто","пятьсот","шестьсот","семьсот","восемьсот","девятьсот"};
        String[] orders = new String[]{"", "тыс", "мил", "миллиард", "триллион", "квадрилион", "квинтиллион", "сикстиллион"};
        String[] thousandOnes = new String[]{"", "одна", "две", "три", "четыре", "пять", "шесть","семь", "восемь", "девять"};
        String[] thousand = new String[]{"", "тысяча", "тысячи", "тысячи", "тысячи", "тысяч", "тысяч", "тысяч", "тысяч", "тысяч"};
        String zero = "ноль";
        String minus = "minus";
        String result = "";

        boolean isNegative = false;
        if (number < 0) {
            isNegative = true;
            number = -number;
        }
        if (number == 0) {
            return zero;
        }
        int orderCount = 0;
        while(number > 0){
            int three = (int) number % 1000;
            number /= 1000;

            int onesValue = three % 10;        // 3
            int tensValue = three / 10 % 10;   // 2
            int hundredsValue = three / 100;

            String threeResult = "";
            if (orderCount == 1){
                if (hundredsValue != 0){
                    threeResult += ones[hundredsValue];
                }
                if (tensValue == 1) {
                    if (!threeResult.isEmpty()) threeResult += " ";

                    threeResult += teens[onesValue];
                } else if (tensValue > 1) {
                    if (!threeResult.isEmpty()) threeResult += " ";

                    threeResult += tens[tensValue];
                }
                if (tensValue != 1 && onesValue != 0){
                    if (!threeResult.isEmpty()) threeResult += " ";

                    threeResult += thousandOnes[onesValue];
                }
                if (!threeResult.isEmpty()) {
                    threeResult += " " + thousand[onesValue];

                    result = threeResult + " " + result;
                }

            }else{
                if (hundredsValue != 0){
                    threeResult += hundred[hundredsValue];
                }
                if (tensValue == 1){
                    if (!threeResult.isEmpty()) threeResult += " ";
                    threeResult += teens[onesValue];
                } else if (tensValue > 1) {
                    if (!threeResult.isEmpty()) threeResult += " ";

                    threeResult += tens[tensValue];
                }
                if (tensValue != 1 && onesValue !=0){
                    if (!threeResult.isEmpty()) threeResult += " ";

                    threeResult += ones[onesValue];
                }
                result += threeResult;
                orderCount++;
            }
        }
        return  result;
    }
}
