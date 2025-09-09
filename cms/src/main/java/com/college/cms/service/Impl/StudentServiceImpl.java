package com.college.cms.service.impl;

import com.college.cms.dto.*;
import com.college.cms.model.Student;
import com.college.cms.repository.StudentRepository;
import com.college.cms.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Student saveStep1(PersonalInfoDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setDateOfBirth(dto.getDateOfBirth());
        student.setPlaceOfBirth(dto.getPlaceOfBirth());
        student.setCitizenship(dto.getCitizenship());
        student.setPermanentAddress(dto.getPermanentAddress());
        student.setContactAddress(dto.getContactAddress());
        student.setEmail(dto.getEmail());
        student.setMobile(dto.getMobile());
        student.setMaritalStatus(dto.getMaritalStatus().name());
        student.setSex(dto.getSex().name());
        student.setResidenceCategory(dto.getResidenceCategory());
        student.setHasDisability(dto.getHasDisability());
        student.setDisabilityType(dto.getDisabilityType() != null ? List.of(dto.getDisabilityType()) : null);
        student.setDisabilityDetails(dto.getDisabilityDetails());
        return studentRepository.save(student);
    }

    @Override
    public Student saveStep2(Long studentId, NextOfKinDTO dto) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setNextOfKinName(dto.getName());
        student.setNextOfKinMobile(dto.getMobile());
        student.setNextOfKinRelationship(dto.getRelationship());
        student.setNextOfKinResidence(dto.getResidence());
        return studentRepository.save(student);
    }

    @Override
    public Student saveStep3(Long studentId, CourseSelectionDTO dto) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setSelectedCourses(List.of(dto.getSelectedCourses()));
        student.setSelectedVetaCourses(List.of(dto.getSelectedVetaCourses()));
        student.setSelectedFreeCourses(List.of(dto.getSelectedFreeCourses()));
        return studentRepository.save(student);
    }

    @Override
    public Student saveStep4(Long studentId, EducationBackgroundDTO dto) throws JsonProcessingException {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setPrimarySchoolJson(objectMapper.writeValueAsString(dto.getPrimarySchool()));
        student.setSecondarySchoolJson(objectMapper.writeValueAsString(dto.getSecondarySchool()));
        student.setAdvancedEducationJson(objectMapper.writeValueAsString(dto.getAdvancedEducation()));
        student.setOtherQualificationsJson(objectMapper.writeValueAsString(dto.getOtherQualifications()));
        return studentRepository.save(student);
    }

    @Override
    public Student saveStep5(Long studentId, SponsorshipDTO dto) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setSponsorshipType(dto.getType());
        student.setSponsorName(dto.getName());
        student.setSponsorAddress(dto.getAddress());
        student.setSponsorMobile(dto.getMobile());
        student.setSponsorEmail(dto.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public Student saveStep6(Long studentId, DeclarationDTO dto) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setAgreeToTerms(dto.isAgreeToTerms());
        return studentRepository.save(student);
    }
}
