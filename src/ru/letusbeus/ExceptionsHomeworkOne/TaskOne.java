package ru.letusbeus.ExceptionsHomeworkOne;

/*
1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
 */

public class TaskOne {
    public static void getArithmeticException(int userNumOne, int userNumTwo) {
        try {
            System.out.println(userNumOne/userNumTwo);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
    static void getIndexOfBoundException(int[] userArray, int userIndex){
        try{
            System.out.println(userArray[userIndex]);
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    static void getNullPointerException(String userString){
        try{
            System.out.println(userString.length());
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }

}

