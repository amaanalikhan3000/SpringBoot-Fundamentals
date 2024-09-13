package com.example.springDemo.student;


import lombok.*;

import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
public class Student {

    private String firstName;

    private String lastName;

    private LocalDate date;

    private String email;

    private int age;
}
