package com.argelastaj.springbootweblogicbtm.model;

import javax.validation.constraints.*;
import java.util.UUID;

public class User {
    private String uuid;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Surname cannot be null")
    private String surname;
    @NotNull(message = "Yaş boş bırakılamaz")
    @Min(value = 13, message = "Age should not be less than 18")
    @Max(value = 120, message = "Age should not be greater than 150")
    private int age;
    @NotNull(message = "Gender cannot be null")
    private String gender;

    public User(){}

    public User(String name, String surname, int age, String gender) {
        this.uuid= UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public User(String uuid, String name, String surname,int age, String gender) {
        this.uuid = uuid;

        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
