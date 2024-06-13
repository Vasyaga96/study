package org.example;

public class NumToEnglish {
    public static void main(String[] args){
        int n = 1011;
        String[] ones = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] teens = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] orders = new String[]{"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion"};
        String hundred = "hundred";
        String zero = "zero";
        String minus = "minus";
        String result = "";
        boolean checkMinus = false;
        if (n < 0){
            checkMinus = true;
            n = n * (-1);
        }
        if (n == 0){
            result = zero;
        }
        int count = 0;
        while (n > 0) {
            String resultOnes, resultTens,resultTeens,resultHundred,resultOrders;
            resultOnes = "";
            resultTens = "";
            resultTeens = "";
            resultHundred = "";
            resultOrders = "";
            int three = n % 1000;
            n = n / 1000;
            if (three >= 100 && three < 1000) {
                resultHundred = ones[three / 100] + ' ' + hundred;
                three = three % 100;
            }
            if (three < 100 && three >= 20){
                resultTens = tens[three / 10];
                three = three % 10;
            }
            if (three >= 10 && three < 20) {
                resultTeens = teens[three % 10];
            }
            if(three < 10 && three > 0){
                resultOnes = ones[three % 10];
            }
            if(count != 0){
                resultOrders = orders[count];
            }
            result = resultHundred + " " + resultTens + " " + resultTeens + " " + resultOnes + " " + resultOrders + result;
            count++;
        }
        if (checkMinus){
            result = minus + result;
        }
        System.out.println(result);
    }
}
