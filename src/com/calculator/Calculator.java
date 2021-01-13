/**
 * Java calculator
 *
 * @author Kirill Lazarev / telegram: @kiranlazarev
 *
 */
package com.calculator;
import java.util.Scanner;

public class Calculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите математическое выражение в формате: 1 +-/* 10 или I +-/* X");
        System.out.println("Можно использовать только целые арабские или римские числа от 1 до 10: ");

        String[] expression = scanner.nextLine().split(" ");
        String[] romanInput = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

        int length = expression.length;
        if (length != 3) {
            System.out.println("Не правильный формат ввода, попробуйте: 1 + 1");
            System.out.println("Программа завершена");
            System.exit(0);
        }

        String prepareLeft = expression[0];
        String formatLeft = prepareLeft.toUpperCase().trim();
        String prepareRight = expression[2];
        String formatRight = prepareRight.toUpperCase().trim();

        char operation = expression[1].charAt(0);
        char checkOperation = com.calculator.Regulations.getOperation(operation);
        boolean flag1num = false, flaq2num = false;

        for (int i = 0; i < romanInput.length; i++) {
            if (romanInput[i].equals(formatLeft)) {
                flag1num = true;
                break;
            }
        }
        for (int i = 0; i < romanInput.length; i++) {
            if (romanInput[i].equals(formatRight)) {
                flaq2num = true;
                break;
            }
        }

        if (flag1num && flaq2num) {
            int numLeft = com.calculator.RomeNumber.convRomanToArabian(formatLeft);
            int numRight = com.calculator.RomeNumber.convRomanToArabian(formatRight);
            int checkNumLeft = com.calculator.Regulations.rangeСheckInt(numLeft);
            int checkNumRight = com.calculator.Regulations.rangeСheckInt(numRight);
            int number = com.calculator.Regulations.calculate(checkNumLeft, checkOperation, checkNumRight);
            String result = com.calculator.RomeNumber.convArabianToRoman(number);
            System.out.println(result);

        } else if (!flag1num && !flaq2num) {
            String[] clearArrayLeft = formatLeft.split("[^0-9-]");
            String[] clearArrayRight = formatRight.split("[^0-9-]");
            String delimiter = "";
            String clearLeft = String.join(delimiter, clearArrayLeft);
            String clearRight = String.join(delimiter, clearArrayRight);

            if (clearLeft.equals("") || clearRight.equals("")) {
                System.out.println("Вы ошиблись. Введите выражение в формате: 1 + 1 или V - III");
                System.out.println("Программа завершена");
                System.exit(0);
            }
            int numLeft = Integer.parseInt(clearLeft);
            int numRight = Integer.parseInt(clearRight);
            int checkNumLeft = com.calculator.Regulations.rangeСheckInt(numLeft);
            int checkNumRight = com.calculator.Regulations.rangeСheckInt(numRight);
            int result = com.calculator.Regulations.calculate(checkNumLeft, checkOperation, checkNumRight);
            System.out.println(result);

        } else {
            System.out.println("Римские числа можно использовать только от: I до X");
            System.out.println("Нельзя совместно использовать числа, разных систем: 5 / X");
            System.out.println("Программа завершена");
            System.exit(0);
        }
        scanner.close();
    }
}