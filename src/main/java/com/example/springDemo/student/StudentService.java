package com.example.springDemo.student;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor

public class StudentService {
    public List<Student> findAllStudents(){
        return List.of(
                new Student(
                        "Alibou",
                        "khan",
                        LocalDate.now(),
                        "aak123@gmail.com",
                        23
                ),
                new Student(
                        "Student2",
                        "khan",
                        LocalDate.now(),
                        "aak123@gmail.com",
                        23
                ),
                new Student(
                        "Alibou2",
                        "khan",
                        LocalDate.now(),
                        "aak13@gmail.com",
                        23
                )
        );
    }
}
