package com.example.springk8s.persistence;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
public class TeacherRedis {

    private final RedisTemplate<String, String> template;


    public TeacherRedis(RedisTemplate<String, String> template) {
        this.template = template;
    }

//    public Teacher


}
