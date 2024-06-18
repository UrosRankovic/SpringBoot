package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
@Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public String displayStudents() {
        List<Student> students = studentRepository.findAll();

            for (Student student : students) {
                return (student.getName());
            }
        return ("End of student display");
    }


    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(int studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if(!exists) {
        throw new IllegalStateException("This student doesnt exist");
    }
    studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(int studentId, String name, String email) {
    boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("This student doesnt exist");
        }
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student doesnt exist"));
        student.setName(name);
        student.setEmail(email);
    }
}
