package com.example.springbootweblogic.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserORC {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id=1;
    @Column(name="name",length = 30)
    private String name;
    @Column(name = "surname",length = 30)
    private String surname;
    @Column(name = "age")
    private int age;
    @Column(name = "gender",length = 7)
    private String gender;

    public UserORC() {}
    public UserORC(String name, String surname, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
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
    public int getId() {
        return id;
    }

}
