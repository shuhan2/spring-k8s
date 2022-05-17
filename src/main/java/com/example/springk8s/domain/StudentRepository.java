package com.example.springk8s.domain;

import com.example.springk8s.domain.other.Student1;

public interface StudentRepository {
    public void save(String id);
    public Student1 get(String id) ;
}
