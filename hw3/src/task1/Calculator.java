package task1;

import java.util.Scanner;

public class Calculator {
    public static <T extends Number, U extends Number> double sum(T num1, U num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T num1, U num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T num1, U num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double subtract(T num1, U num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static void main(String[] args) {
        int num1 = 15;
        float num2 = 3.0f;

        System.out.println(num1 + " + " + num2 + " = " + sum(num1, num2));
        System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));

        try {
            System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println(num1 + " - " + num2 + " = " + subtract(num1, num2));

    }
}