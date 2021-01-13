package com.calculator;

public class Regulations {

    public static int rangeСheckInt(int num) {
            if (num < 1 || num > 10) {
                System.out.println("Число должно быть целым, не меньше 1 и не больше 10");
                System.out.println("Программа завершена");
                System.exit(0);
            }
        return num;
    }

    public static char getOperation(char operation) {
        if (operation == '+' || operation == '-' || operation == '/' || operation == '*') {
            return operation;
        } else {
            System.out.println("Для вычислений используйте только: '+' '-' '/' '*'");
            System.out.println("Программа завершена");
            System.exit(0);
        }
        return operation;
    }

    public static int calculate(int numLeft, char operation, int numRight) {
        int result = 0;
        switch (operation) {
            case '+': result = numLeft + numRight; break;
            case '-': result = numLeft - numRight; break;
            case '*': result = numLeft * numRight; break;
            case '/': result = numLeft / numRight; break;
            default:
                System.out.println("Операция не распознана.");
                System.out.println("Программа завершена");
                System.exit(0);
        }
        return result;
    }
}

