package com.college.cms.service;

import com.college.cms.model.Student;
import com.college.cms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> listAll() {
        return repo.findAll();
    }

    public Student save(Student student) {
        return repo.save(student);
    }
}

