package com.college.cms.controllers;

import com.college.cms.model.Student;
import com.college.cms.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.listAll();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.save(student);
    }



}
