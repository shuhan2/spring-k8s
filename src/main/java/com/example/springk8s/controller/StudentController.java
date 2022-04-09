package com.example.springk8s.controller;

import com.example.springk8s.domain.Student;
import com.example.springk8s.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id) {
        studentService.saveStudent(id);
    }

    @GetMapping("/{id}")
    public String get(@PathVariable String id) {
        return studentService.getStudent(id);
    }
}
