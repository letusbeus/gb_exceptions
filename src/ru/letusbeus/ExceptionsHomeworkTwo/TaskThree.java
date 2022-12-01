package ru.letusbeus.ExceptionsHomeworkTwo;

/*
Если необходимо, исправьте данный код
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
 */

public class TaskThree {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 0;
            String x = null;
            int[] abc = {1, 2};
            System.out.println(abc[3]); // Вызовет IndexOutOfBoundsException
            abc[3] = 9; // Вызовет IndexOutOfBoundsException
            System.out.println(x.length()); // Вызовет NullPointerException
            System.out.println(a / b); // Вызовет ArithmeticException
            printSum(23, 234); // Исключение невозможно

        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }// исключение FileNotFoundException при данной операции невозможно

}
