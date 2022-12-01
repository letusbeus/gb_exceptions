package ru.letusbeus.ExceptionsHomeworkTwo;

import java.util.InputMismatchException;
import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

public class TaskOne {
    public static void checkIfUserNumberIsFloat() {
        while (true) {
            System.out.println("Введите дробное число:");
            Scanner sc = new Scanner(System.in);
            try {
                float userFloat = sc.nextFloat();
                System.out.println(userFloat);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введенное значение не является дробным числом, пожалуйста, повторите ввод:");
            }
        }
    }
}