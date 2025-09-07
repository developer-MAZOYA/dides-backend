package com.college.cms.service.Impl;

import com.college.cms.dto.requestDTOs.*;
import com.college.cms.dto.responseDTOs.StudentResponse;
import com.college.cms.exception.ResourceNotFoundException;
import com.college.cms.model.Student;
import com.college.cms.model.User;
import com.college.cms.repository.StudentRepository;
import com.college.cms.repository.UserRepository;
import com.college.cms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    // ------------------- SAVE -------------------
    @Override
    public StudentResponse savePersonalInfo(PersonalInfoRequest request, String username) {
        Student student = getOrCreateStudent(username);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    @Override
    public StudentResponse saveNextOfKin(NextOfKinRequest request, String username) {
        Student student = getOrCreateStudent(username);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    @Override
    public StudentResponse saveCourses(CourseSelectionRequest request, String username) {
        Student student = getOrCreateStudent(username);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    @Override
    public StudentResponse saveEducation(EducationRequest request, String username) {
        Student student = getOrCreateStudent(username);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    @Override
    public StudentResponse saveSponsorship(SponsorshipRequest request, String username) {
        Student student = getOrCreateStudent(username);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    // ------------------- FETCH -------------------
    @Override
    public StudentResponse getApplicationById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public StudentResponse getApplicationByUsername(String username) {
        Student student = studentRepository.findByUser_Username(username)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found for username: " + username));
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public List<StudentResponse> getAllApplications() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
    }

    // ------------------- UPDATE -------------------
    @Override
    public StudentResponse updatePersonalInfo(Long id, PersonalInfoRequest request) {
        Student student = getStudentById(id);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    @Override
    public StudentResponse updateNextOfKin(Long id, NextOfKinRequest request) {
        Student student = getStudentById(id);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    @Override
    public StudentResponse updateCourses(Long id, CourseSelectionRequest request) {
        Student student = getStudentById(id);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    @Override
    public StudentResponse updateEducation(Long id, EducationRequest request) {
        Student student = getStudentById(id);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    @Override
    public StudentResponse updateSponsorship(Long id, SponsorshipRequest request) {
        Student student = getStudentById(id);
        modelMapper.map(request, student);
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
    }

    // ------------------- DELETE -------------------
    @Override
    public void deleteApplication(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }

    // ------------------- HELPERS -------------------
    private Student getOrCreateStudent(String username) {
        return studentRepository.findByUser_Username(username)
                .orElseGet(() -> {
                    User user = userRepository.findByUsername(username)
                            .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));
                    Student newStudent = new Student();
                    newStudent.setUser(user);
                    return newStudent;
                });
    }

    private Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
    }
}
