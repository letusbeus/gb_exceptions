package ru.letusbeus.ExceptionsHomeworkThree;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки
дата_рождения - строка формата dd.mm.yyyy
номер_телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки,
обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Services {
    static String[] personsData = checkInputData();

    public static void createPerson() {
        Person human = new Person();
        for (String personsDatum : personsData) {
            if (personsDatum.contains(".")) {
                human.setBirthDate(personsDatum);
            } else if (personsDatum.chars().allMatch(Character::isDigit)) {
                human.setPhoneNumber(personsDatum);
            } else if (
                    (personsDatum.equalsIgnoreCase("Ж")) ||
                            (personsDatum.equalsIgnoreCase("М"))) {
                human.setGender(personsDatum);
            } else if ((personsDatum.length() > 1) && (personsDatum.chars().allMatch(Character::isLetter))) {
                if (personsDatum.endsWith("ович") ||
                        (personsDatum.endsWith("овна")) ||
                        (personsDatum.endsWith("евич")) ||
                        (personsDatum.endsWith("евна")) ||
                        (personsDatum.endsWith("ич")) ||
                        (personsDatum.endsWith("ична"))) {
                    human.setLastName(personsDatum);
                } else if (personsDatum.endsWith("ов") ||
                        (personsDatum.endsWith("ова")) ||
                        (personsDatum.endsWith("ев")) ||
                        (personsDatum.endsWith("ева")) ||
                        (personsDatum.endsWith("ин")) ||
                        (personsDatum.endsWith("ина")) ||
                        (personsDatum.endsWith("ын")) ||
                        (personsDatum.endsWith("ына"))) {
                    human.setSurname(personsDatum);
                } else human.setName(personsDatum);
            }
        }
        System.out.println(human);
    }

    public static String[] checkInputData() {
        // 12.12.12 Иванов 999999999 Иванович Иван м
        Scanner sc = new Scanner(System.in);
        String[] persons = sc.nextLine().split(" ");
        if (persons.length != 6) {
            throw new RuntimeException("Incorrect data");
        } else {
////            System.out.println(Arrays.toString(persons));
//            try (FileWriter data = new FileWriter(persons[0] + ".txt")) {
//                data.append(Arrays.toString(persons));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            personsData = persons;
            return personsData;
        }
    }
}
