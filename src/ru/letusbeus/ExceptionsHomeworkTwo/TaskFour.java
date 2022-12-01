package ru.letusbeus.ExceptionsHomeworkTwo;

/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

import java.util.Scanner;

public class TaskFour {
    public static void printUserString() {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        if (userInput.trim().isEmpty()) {
            throw new NullPointerException("Empty string is not allowed");
        } else System.out.printf("Entered string: %s", userInput);
    }
}
