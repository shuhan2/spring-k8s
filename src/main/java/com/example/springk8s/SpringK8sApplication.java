package com.example.springk8s;

import com.example.springk8s.domain.Teacher;
import com.example.springk8s.persistence.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringK8sApplication implements CommandLineRunner {
  private final TeacherRepository teacherRepository;

    public SpringK8sApplication(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringK8sApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        teacherRepository.save(new Teacher("cao", 29));
    }
}
