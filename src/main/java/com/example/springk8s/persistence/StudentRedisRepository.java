package com.example.springk8s.persistence;

import com.example.springk8s.domain.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRedisRepository {

    private final RedisTemplate<String, String> redisTemplate;
    private final RedisTemplate<String, Object> redisObjectTemplate;

    public StudentRedisRepository(RedisTemplate<String, String> redisTemplate, RedisTemplate<String, Object> redisObjectTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisObjectTemplate = redisObjectTemplate;
    }

    public void save(String id) {
        Student sincere = new Student(id, "sincere", Student.Gender.MALE, 29);
        redisTemplate.opsForValue().set("student:" + id,  sincere.toString());
        redisObjectTemplate.opsForValue().set("student:object:" + id,  sincere);
    }

    public Object get(String id) {

       return  redisObjectTemplate.opsForValue().get("student:" +id);
    }


}
