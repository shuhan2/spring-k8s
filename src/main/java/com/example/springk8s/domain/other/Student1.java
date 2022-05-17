package com.example.springk8s.domain.other;

import com.example.springk8s.domain.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties("@class")
public class Student1 implements Serializable {
    public enum Gender {
        MALE, FEMALE;

    }

    private String id;
    private String name;
    private Student.Gender gender;

    public Student1() {
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

    public Student1(String id, String name, Student.Gender gender, int grade) {
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

    public void setGender(Student.Gender gender) {
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

    public Student.Gender getGender() {
        return gender;
    }

    public int getGrade() {
        return grade;
    }
}
