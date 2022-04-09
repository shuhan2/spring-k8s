package com.example.springk8s.persistence;

import com.example.springk8s.domain.Student;
import com.example.springk8s.domain.other.Student1;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisRepository {

    @Cacheable(cacheNames = "student" )
    public Optional<Student1> findById(String id) {
        return Optional.of(new Student1("2", "man", Student.Gender.FEMALE, 28));
    }
}
