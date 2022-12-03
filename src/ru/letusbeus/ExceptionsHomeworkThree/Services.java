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


import java.io.*;
import java.util.Scanner;

public class Services {
    static String[] personsData = checkInputData();
    static String[] patronymics = {"ович", "овна", "евич", "евна", "ич", "ична"};
    static String[] surnames = {"ов", "ова", "ев", "ева", "ин", "ина", "ын", "ына"};
    static String[] notNames = {"ович", "овна", "евич", "евна", "ич", "ична", "ов", "ова", "ев", "ева", "ин", "ина", "ын", "ына"};

    public static Person createPerson() {
        Person human = new Person();
        for (String personsDatum : personsData) {
            if (personsDatum.contains(".") &&
                    (personsDatum.replace(".", "").chars().allMatch(Character::isDigit))) {
                human.setBirthDate(personsDatum);
            } else if (personsDatum.chars().allMatch(Character::isDigit)) {
                human.setPhoneNumber(personsDatum);
            } else if ((personsDatum.equalsIgnoreCase("Ж")) ||
                    (personsDatum.equalsIgnoreCase("М"))) {
                human.setGender(personsDatum);
            } else if ((personsDatum.length() > 1) && (personsDatum.chars().allMatch(Character::isLetter))) {
                if (isName(personsDatum)) {
                    human.setName(personsDatum);
                }
                if (isSurname(personsDatum)) {
                    human.setSurname(personsDatum);
                }
                if (isPatronymic(personsDatum)) {
                    human.setLastName(personsDatum);
                }
            }
        }

        if (human.getName() == null) {
            throw new RuntimeException("Поле \"имя\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getLastName() == null) {
            throw new RuntimeException("Поле \"отчество\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getSurname() == null) {
            throw new RuntimeException("Поле \"фамилия\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getGender() == null) {
            throw new RuntimeException("Поле \"пол\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getBirthDate() == null) {
            throw new RuntimeException("Поле \"дата рождения\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getPhoneNumber() == null) {
            throw new RuntimeException("Поле \"номер телефона\" заполнено некорректно, пожалуйста, проверьте ввод!");
        }
        return human;
    }


    public static String[] checkInputData() {
        System.out.println(
                "Пожалуйста, введите данные через пробел (Фамилия, Имя, Отчество, пол, дата рождения, номер телефона):"
        );
        Scanner sc = new Scanner(System.in);
        String[] persons = sc.nextLine().split(" ");
        if (persons.length != 6) {
            throw new RuntimeException("Не хватает данных, пожалуйста, проверьте ввод");
        } else {
            personsData = persons;
            return personsData;
        }
    }

    public static boolean isName(String personDatum) {
        for (String notName : notNames) {
            if (personDatum.endsWith(notName)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSurname(String personDatum) {
        for (String surname : surnames) {
            if (personDatum.endsWith(surname)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPatronymic(String personDatum) {
        for (String patronymic : patronymics) {
            if (personDatum.endsWith(patronymic)) {
                return true;
            }
        }
        return false;
    }

    public static void writeInUserFile() {
        File writer = new File(createPerson().getSurname() + ".txt");
        try (FileWriter userFile = new FileWriter(writer, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(userFile);
            bufferedWriter.write(createPerson() + "\n");
            bufferedWriter.close();
            System.out.printf("Операция записи в файл %s успешно завершена!\n" +
                    "Добавлена следующая строка: %s", writer, createPerson());
        } catch (IOException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
