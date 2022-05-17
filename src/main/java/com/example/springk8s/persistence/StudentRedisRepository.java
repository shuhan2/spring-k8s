package com.example.springk8s.persistence;

import com.example.springk8s.domain.Student;
import com.example.springk8s.domain.StudentRepository;
import com.example.springk8s.domain.other.Student1;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRedisRepository implements StudentRepository {

    private final RedisTemplate<String, String> redisTemplate;
    private final RedisTemplate<String, Object> redisObjectTemplate;
    private final MongoTemplate mongoTemplate;


    public StudentRedisRepository(RedisTemplate<String, String> redisTemplate, RedisTemplate<String, Object> redisObjectTemplate, MongoTemplate mongoTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisObjectTemplate = redisObjectTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    public void save(String id) {
        Student sincere = new Student(id, "sincere", Student.Gender.MALE, 29);
       mongoTemplate.save(sincere);
    }

//    @Cacheable(key = "#id")
    public Student1 get(String id) {
        String s = get1(id);
//
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Student student = mongoTemplate.find(query, Student.class).get(0);
        return mongoTemplate.find(query, Student1.class).get(0);
    }

    @Cacheable(cacheNames = "student", key = "#id")
    public Student getStudent(String id) {
        String s = get1(id);
//
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.find(query, Student.class).get(0);
    }

    public String get1(String id) {

        String o = redisTemplate.opsForValue().get("student:" + id);
        return o;
    }


}
