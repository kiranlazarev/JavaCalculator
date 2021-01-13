package com.calculator;

public class RomeNumber {

    public static int convRomanToArabian(String str) {
        int value = 0;
        int lastNumber = 0;
        String romanNumeral = str.toUpperCase().trim();
        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToNumber = romanNumeral.charAt(x);

            switch (convertToNumber) {
                case 'M':
                    value = conversionProcess(1000, lastNumber, value);
                    lastNumber = 1000;
                    break;

                case 'D':
                    value = conversionProcess(500, lastNumber, value);
                    lastNumber = 500;
                    break;

                case 'C':
                    value = conversionProcess(100, lastNumber, value);
                    lastNumber = 100;
                    break;

                case 'L':
                    value = conversionProcess(50, lastNumber, value);
                    lastNumber = 50;
                    break;

                case 'X':
                    value = conversionProcess(10, lastNumber, value);
                    lastNumber = 10;
                    break;

                case 'V':
                    value = conversionProcess(5, lastNumber, value);
                    lastNumber = 5;
                    break;

                case 'I':
                    value = conversionProcess(1, lastNumber, value);
                    lastNumber = 1;
                    break;
            }
        }
        return value;
    }
    public static int conversionProcess(int value, int lastNumber, int lastValue) {
        if (lastNumber > value) {
            return lastValue - value;
        } else {
            return lastValue + value;
        }
    }

    public static String convArabianToRoman(int sum) {
        if (sum < 1) {
            System.out.println("У Римлян не было отрицательных чисел :)");
            System.out.println("Программа завершена");
            System.exit(0);
        } else if (sum > 3999) {
            System.out.println("У Римлян цисла заканчивались на 3999 :)");
            System.out.println("Программа завершена");
            System.exit(0);
        }
        int[] romanValueList = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanCharList = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < romanValueList.length; i += 1) {
            while (sum >= romanValueList[i]) {
                sum -= romanValueList[i];
                result.append(romanCharList[i]);
            }
        }
        return result.toString();
    }
}