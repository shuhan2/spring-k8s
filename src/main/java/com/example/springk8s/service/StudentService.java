package com.example.springk8s.service;

import com.example.springk8s.domain.Student;
import com.example.springk8s.persistence.StudentRedisRepository;
import com.example.springk8s.persistence.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentRedisRepository studentRedisRepository;

    public StudentService(StudentRepository studentRepository, StudentRedisRepository studentRedisRepository) {
        this.studentRepository = studentRepository;
        this.studentRedisRepository = studentRedisRepository;
    }

    public void saveStudent(String id) {
        studentRedisRepository.save(id);
    }

    public String getStudent(String id) {

        return studentRedisRepository.get(id);
    }
}