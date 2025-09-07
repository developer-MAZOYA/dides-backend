package com.college.cms.dto.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String lastName;
    private Boolean hasDisability;
    private String firstName;
    private LocalDate dateOfBirth;
    private String gender;
    private String placeOfBirth;
    private String citizenship;
    private String maritalStatus;
    private String permanentAddress;
    private String contactAddress;
    private String email;
    private String mobileNumber;
    private String residenceCategory;
    private String nextOfKinName;
    private String nextOfKinMobile;
    private String nextOfKinRelationship;
    private String nextOfKinResidence;
    private String firstChoiceCourse;
    private String secondChoiceCourse;
    private String shortCourseChoice;
    private String sponsorshipType;
    private String sponsorFullName;
    private String sponsorPostalAddress;
    private String sponsorMobileNumber;
    private String sponsorEmailAddress;
    private String secondarySchoolName;
    private String secondarySchoolIndexNumber;
}