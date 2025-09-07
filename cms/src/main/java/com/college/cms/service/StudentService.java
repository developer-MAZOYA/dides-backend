package com.college.cms.service;

import com.college.cms.dto.requestDTOs.CourseSelectionRequest;
import com.college.cms.dto.requestDTOs.EducationRequest;
import com.college.cms.dto.requestDTOs.NextOfKinRequest;
import com.college.cms.dto.requestDTOs.PersonalInfoRequest;
import com.college.cms.dto.requestDTOs.SponsorshipRequest;
import com.college.cms.dto.responseDTOs.StudentResponse;

import java.util.List;

public interface StudentService {
    // Save sections
    StudentResponse savePersonalInfo(PersonalInfoRequest request, String username);
    StudentResponse saveNextOfKin(NextOfKinRequest request, String username);
    StudentResponse saveCourses(CourseSelectionRequest request, String username);
    StudentResponse saveEducation(EducationRequest request, String username);
    StudentResponse saveSponsorship(SponsorshipRequest request, String username);

    // Fetch applications
    StudentResponse getApplicationById(Long id);
    StudentResponse getApplicationByUsername(String username);
    List<StudentResponse> getAllApplications();

    // Update sections
    StudentResponse updatePersonalInfo(Long id, PersonalInfoRequest request);
    StudentResponse updateNextOfKin(Long id, NextOfKinRequest request);
    StudentResponse updateCourses(Long id, CourseSelectionRequest request);
    StudentResponse updateEducation(Long id, EducationRequest request);
    StudentResponse updateSponsorship(Long id, SponsorshipRequest request);

    // Delete application
    void deleteApplication(Long id);
}