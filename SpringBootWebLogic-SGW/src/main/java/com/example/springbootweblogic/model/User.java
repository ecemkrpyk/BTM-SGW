package com.example.springbootweblogic.model;

public class User {
    private String uuid;
    private String name;
    private String surname;
    private int age;
    private String gender;

    public User(){

    }
    public User(String name, String surname, int age, String gender,String uuid) {
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
        return "UserDetail: [uuid=" + uuid + ", name=" + name + ", surname=" + surname + ", age=" + age + ", gender="
                + gender + "]";
    }
}
