package com.example.springk8s.service;

import com.example.springk8s.domain.Student;
import com.example.springk8s.domain.StudentRepository;
import com.example.springk8s.domain.other.Student1;
import com.example.springk8s.persistence.RedisRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRedisRepository;
    private final RedisRepository redisRepository;

    public StudentService(StudentRepository studentRedisRepository, RedisRepository redisRepository) {
        this.studentRedisRepository = studentRedisRepository;
        this.redisRepository = redisRepository;
    }

    public void saveStudent(String id) {
        studentRedisRepository.save(id);
    }

    public Student1 getStudent(String id) {
        Student student = redisRepository.findById(id).get();
        return studentRedisRepository.get(id);
    }
}
