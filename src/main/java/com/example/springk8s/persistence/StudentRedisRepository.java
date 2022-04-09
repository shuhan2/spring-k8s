package com.example.springk8s.persistence;

import com.example.springk8s.domain.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public StudentRedisRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(String id) {
        Student sincere = new Student(id, "sincere", Student.Gender.MALE, 29);
        redisTemplate.opsForValue().append("student:" +id,  sincere.toString());
    }

    public String get(String id) {

       return redisTemplate.opsForValue().get("student:" +id);
    }


}
