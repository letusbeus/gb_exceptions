package ru.letusbeus.ExceptionsHomeworkOne;

import java.util.Arrays;

/*
2. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */

public class TaskTwo {
    public static String divideTwoArrays(int[] first, int[] second) {
        if (first.length == second.length) {
            int[] result = new int[first.length];
            for (int i = 0; i < result.length; i++) {
                if (first[i] == 0) {
                    if (second[i] == 0)
                        throw new RuntimeException("Деление нуля на ноль не имеет смысла, частное может быть любым числом.");
                    else throw new RuntimeException("Делимое не может быть равно нулю.");
                } else if (second[i] == 0) throw new RuntimeException("На ноль делить нельзя.");
                else result[i] = first[i] / second[i];
            }
            return Arrays.toString(result);
        } else throw new RuntimeException("Длины массивов неравны, операция невозможна.");
    }
}