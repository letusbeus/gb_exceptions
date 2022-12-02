package ru.letusbeus.ExceptionsHomeworkThree;

public class Person {
    private String name;
    private String lastName;
    private String surname;
    private String gender;
    private String phoneNumber;
    private String birthDate;

    public Person() {
    }
    public Person(String name, String lastName, String surname, String gender, String birthDate, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return surname + " " +
                name + " " +
                lastName + " " +
                birthDate + " " +
                phoneNumber + " " +
                gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSurname() {
        return surname;
    }
    public String getGender() {
        return gender;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getBirthDate() {
        return birthDate;
    }
}
