package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(int id, Student updatedStudent) {
        return repository.findById(id)
                .map(s -> {
                    s.setName(updatedStudent.getName());
                    s.setAge(updatedStudent.getAge());
                    return repository.save(s);
                })
                .orElse(null);
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}
