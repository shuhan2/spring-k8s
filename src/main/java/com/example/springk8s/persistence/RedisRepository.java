package com.example.springk8s.persistence;

import com.example.springk8s.domain.Student;
import com.example.springk8s.domain.other.Student1;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisRepository {
    private final StudentRedisRepository studentRedisRepository;

    public RedisRepository(StudentRedisRepository studentRedisRepository) {
        this.studentRedisRepository = studentRedisRepository;
    }

    @Cacheable(cacheNames = "student", key = "#id")
    public Optional<Student>   findById(String id) {
        return Optional.of(studentRedisRepository.getStudent(id));
    }
}
