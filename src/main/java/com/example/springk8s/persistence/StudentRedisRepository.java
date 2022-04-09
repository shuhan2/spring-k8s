package com.example.springk8s.persistence;

import com.example.springk8s.domain.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        String s = get1(id);
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//           return objectMapper.readValue(s, Student.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        return  redisObjectTemplate.opsForValue().get("student:" +id);
    }

    public String get1(String id) {

        String o = redisTemplate.opsForValue().get("student:" + id);
        return o;
    }


}
