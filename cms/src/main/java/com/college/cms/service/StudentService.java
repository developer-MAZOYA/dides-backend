package com.college.cms.service;

import com.college.cms.dto.PersonalInfoRequest;
import com.college.cms.dto.NextOfKinRequest;
import com.college.cms.dto.CourseSelectionRequest;
import com.college.cms.dto.EducationBackgroundRequest;
import com.college.cms.dto.SponsorshipRequest;
import com.college.cms.dto.DeclarationDTO;
import com.college.cms.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StudentService {
    Student saveStep1(PersonalInfoRequest dto);
    Student saveStep2(Long studentId, NextOfKinRequest dto);
    Student saveStep3(Long studentId, CourseSelectionRequest dto);
    Student saveStep4(Long studentId, EducationBackgroundRequest dto) throws JsonProcessingException;
    Student saveStep5(Long studentId, SponsorshipRequest dto);
    Student saveStep6(Long studentId, DeclarationDTO dto);
}
