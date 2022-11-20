package org.example;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age; //не final т.к. может меняться
    protected String address; //не final т.к. может меняться

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setAgeIfAbsent(int age) throws Exception {
        if (!hasAge()) {
            this.age = age;
        } else {
            throw new Exception("You cannot specify the age of the person who has it set");
        }
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        }
        return OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode();
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }
}
