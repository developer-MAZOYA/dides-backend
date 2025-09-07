package com.college.cms.controllers;

import com.college.cms.dto.requestDTOs.CourseSelectionRequest;
import com.college.cms.dto.requestDTOs.EducationRequest;
import com.college.cms.dto.requestDTOs.NextOfKinRequest;
import com.college.cms.dto.requestDTOs.PersonalInfoRequest;
import com.college.cms.dto.requestDTOs.SponsorshipRequest;
import com.college.cms.dto.responseDTOs.StudentResponse;
import com.college.cms.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // 🔹 Page 1: Personal Info
    @PostMapping("/application/personal-info")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<StudentResponse> savePersonalInfo(
            @Valid @RequestBody PersonalInfoRequest personalInfoRequest) {
        String username = getCurrentUsername();
        StudentResponse student = studentService.savePersonalInfo(personalInfoRequest, username);
        return ResponseEntity.ok(convertToResponse(student));
    }

    // 🔹 Page 2: Next of Kin
    @PostMapping("/application/next-of-kin")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<StudentResponse> saveNextOfKin(
            @Valid @RequestBody NextOfKinRequest nextOfKinRequest) {
        String username = getCurrentUsername();
        StudentResponse student = studentService.saveNextOfKin(nextOfKinRequest, username);
        return ResponseEntity.ok(convertToResponse(student));
    }

    // 🔹 Page 3: Course Selection
    @PostMapping("/application/courses")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<StudentResponse> saveCourses(
            @Valid @RequestBody CourseSelectionRequest courseSelectionRequest) {
        String username = getCurrentUsername();
        StudentResponse student = studentService.saveCourses(courseSelectionRequest, username);
        return ResponseEntity.ok(convertToResponse(student));
    }

    // 🔹 Page 4: Education
    @PostMapping("/application/education")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<StudentResponse> saveEducation(
            @Valid @RequestBody EducationRequest educationRequest) {
        String username = getCurrentUsername();
        StudentResponse student = studentService.saveEducation(educationRequest, username);
        return ResponseEntity.ok(convertToResponse(student));
    }

    // 🔹 Page 5: Sponsorship
    @PostMapping("/application/sponsorship")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<StudentResponse> saveSponsorship(
            @Valid @RequestBody SponsorshipRequest SponsorshipRequest) {
        String username = getCurrentUsername();
        StudentResponse student = studentService.saveSponsorship(SponsorshipRequest, username);
        return ResponseEntity.ok(convertToResponse(student));
    }

    // 🔹 Fetch my application (whole)
    @GetMapping("/my-application")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<StudentResponse> getMyApplication() {
        String username = getCurrentUsername();
        StudentResponse application = studentService.getApplicationByUsername(username);
        return ResponseEntity.ok(application);
    }

    // 🔹 Staff/Admin fetch specific student
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('STAFF') or hasRole('ADMIN')")
    public ResponseEntity<StudentResponse> getApplicationById(@PathVariable Long id) {
        StudentResponse application = studentService.getApplicationById(id);
        return ResponseEntity.ok(application);
    }

    // 🔹 Staff/Admin fetch all
    @GetMapping
    @PreAuthorize("hasRole('STAFF') or hasRole('ADMIN')")
    public ResponseEntity<?> getAllApplications() {
        return ResponseEntity.ok(studentService.getAllApplications());
    }

    // 🔹 Delete application (Admin only)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteApplication(@PathVariable Long id) {
        studentService.deleteApplication(id);
        return ResponseEntity.ok().body("Application deleted successfully");
    }

    // 🔹 Helper: current user
    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    // 🔹 Helper: convert entity → response DTO
    private StudentResponse convertToResponse(StudentResponse student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setLastName(student.getLastName());
        response.setHasDisability(student.getHasDisability());
        response.setFirstName(student.getFirstName());
        response.setDateOfBirth(student.getDateOfBirth());
        response.setGender(student.getGender());
        response.setPlaceOfBirth(student.getPlaceOfBirth());
        response.setCitizenship(student.getCitizenship());
        response.setMaritalStatus(student.getMaritalStatus());
        response.setPermanentAddress(student.getPermanentAddress());
        response.setContactAddress(student.getContactAddress());
        response.setEmail(student.getEmail());
        response.setMobileNumber(student.getMobileNumber());
        response.setResidenceCategory(student.getResidenceCategory());
        response.setNextOfKinName(student.getNextOfKinName());
        response.setNextOfKinMobile(student.getNextOfKinMobile());
        response.setNextOfKinRelationship(student.getNextOfKinRelationship());
        response.setNextOfKinResidence(student.getNextOfKinResidence());
        response.setFirstChoiceCourse(student.getFirstChoiceCourse());
        response.setSecondChoiceCourse(student.getSecondChoiceCourse());
        response.setShortCourseChoice(student.getShortCourseChoice());
        response.setSponsorshipType(student.getSponsorshipType());
        response.setSponsorFullName(student.getSponsorFullName());
        response.setSponsorPostalAddress(student.getSponsorPostalAddress());
        response.setSponsorMobileNumber(student.getSponsorMobileNumber());
        response.setSponsorEmailAddress(student.getSponsorEmailAddress());
        response.setSecondarySchoolName(student.getSecondarySchoolName());
        response.setSecondarySchoolIndexNumber(student.getSecondarySchoolIndexNumber());
        return response;
    }
}
