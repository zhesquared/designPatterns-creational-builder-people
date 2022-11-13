package org.example;

public class PersonBuilder {

    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null) {
            throw new IllegalStateException("Field \"Name\" is empty");
        } else {
            this.name = name;
            return this;
        }
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null) {
            throw new IllegalStateException("Field \"Surname\" is empty");
        } else {
            this.surname = surname;
            return this;
        }
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 122) {
            throw new IllegalArgumentException("Field \"Age\" cannot be less than zero.");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Field \"Name\" is empty.");
        }
        if (surname == null) {
            throw new IllegalStateException("Field \"Surname\" is empty.");
        }
        return new Person(name, surname, age);
    }
}