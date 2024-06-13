package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class StudentService {
        public List<Student> displayStudent() {
            return List.of(new  Student(
                    1, "Mariam",
                    "test@gmail.com",
                    LocalDate.of(2000,10,10),
                    25
            )
            );
        }
}
