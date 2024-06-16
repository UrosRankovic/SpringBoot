package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "test@gmail.com",
                    LocalDate.of(2000, JANUARY, 5),
                    21
            );
            Student luke = new Student(
                    "Luke",
                    "test@gmail.com",
                    LocalDate.of(2000, JANUARY, 5),
                    21
            );
            repository.saveAll(
                    List.of(mariam,luke)
            );
        };
    }
}
