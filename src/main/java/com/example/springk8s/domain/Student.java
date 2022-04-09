package com.example.springk8s.domain;


import java.io.Serializable;
import java.util.Objects;

//@RedisHash("Student")
public class Student implements Serializable {

    public enum Gender {
        MALE, FEMALE;

    }

    private String id;
    private String name;
    private Gender gender;

    public Student() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + '\"' +
                ", \"name\": \"" + name + '\"' +
                ", \"gender\": \"" + gender.name() + '\"' +
                ", \"grade\": " + grade +
                "}";
    }

    private int grade;

    public Student(String id, String name, Gender gender, int grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getGrade() {
        return grade;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return grade == student.grade && Objects.equals(id, student.id) && Objects.equals(name, student.name) && gender == student.gender;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, gender, grade);
//    }
}
