package com.example.springk8s.domain;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
public class Student {

    public enum Gender {
        MALE, FEMALE;

    }

    private String id;
    private String name;
    private Gender gender;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", grade=" + grade +
                '}';
    }

    private int grade;

    public Student(String id, String name, Gender gender, int grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }
}
