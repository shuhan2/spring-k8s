package com.example.springk8s.persistence;

import com.example.springk8s.domain.Student;
import com.example.springk8s.domain.other.Student1;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRedisRepository {

    private final RedisRepository redisRepository;
    private final RedisTemplate<String, String> redisTemplate;
    private final RedisTemplate<String, Object> redisObjectTemplate;

    public StudentRedisRepository(RedisRepository redisRepository, RedisTemplate<String, String> redisTemplate, RedisTemplate<String, Object> redisObjectTemplate) {
        this.redisRepository = redisRepository;
        this.redisTemplate = redisTemplate;
        this.redisObjectTemplate = redisObjectTemplate;
    }

    public void save(String id) {
        Student sincere = new Student(id, "sincere", Student.Gender.MALE, 29);
        redisTemplate.opsForValue().set( id,  sincere.toString());
        redisObjectTemplate.opsForValue().set("student:object:" + id,  sincere);
    }

    public Student1 get(String id) {
        String s = get1(id);
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//           return objectMapper.readValue(s, Student.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        return redisRepository.findById(id).get();
//        return (Student1) redisObjectTemplate.opsForValue().get("student:" +id);
    }

    public String get1(String id) {

        String o = redisTemplate.opsForValue().get("student:" + id);
        return o;
    }


}
