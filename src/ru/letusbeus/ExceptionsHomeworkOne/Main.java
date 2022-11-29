package ru.letusbeus.ExceptionsHomeworkOne;

import static ru.letusbeus.ExceptionsHomeworkOne.TaskOne.getArithmeticException;
import static ru.letusbeus.ExceptionsHomeworkOne.TaskOne.getIndexOfBoundException;
import static ru.letusbeus.ExceptionsHomeworkOne.TaskOne.getNullPointerException;


public class Main {
    public static void main(String[] args) {
        System.out.println("Task One");
        getArithmeticException(1, 1);
        getArithmeticException(1, 0);
        getIndexOfBoundException(new int[] {1, 2}, 0);
        getIndexOfBoundException(new int[] {1, 2}, 3);
        getNullPointerException("null");
        getNullPointerException(null);
        System.out.println("\nTask Two");
        System.out.println(TaskTwo.divideTwoArrays(new int[]{-1, 2}, new int[]{1, 1}));
        System.out.println(TaskTwo.divideTwoArrays(new int[]{1, 2}, new int[]{1}));
//        System.out.println(TaskTwo.divideTwoArrays(new int[]{0, 2}, new int[]{1, 2}));
//        System.out.println(TaskTwo.divideTwoArrays(new int[]{1, 2}, new int[]{1, 0}));
//        System.out.println(TaskTwo.divideTwoArrays(new int[]{1, 0}, new int[]{1, 0}));
    }
}

