package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    Student test = new  Student(
            1, "Mariam",
            "test@gmail.com",
            LocalDate.of(2000,10,10),
            25
    );
    Student test1 = new  Student(
            2, "Mariam2",
            "test@gmail.com",
            LocalDate.of(2000,10,10),
            23
    );
    @GetMapping
    public List <Student> displayStudent() {
        return List.of(test, test1);
    }
}
