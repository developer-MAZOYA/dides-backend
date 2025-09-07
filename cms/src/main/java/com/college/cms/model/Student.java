package com.college.cms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal Information (Page 1)
    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50)
    private String lastName;

    @NotNull(message = "Disability status is mandatory")
    private Boolean hasDisability;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 100)
    private String firstName;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is mandatory")
    private String gender; // Male, Female

    @NotBlank(message = "Place of birth is mandatory")
    private String placeOfBirth;

    @NotBlank(message = "Citizenship is mandatory")
    private String citizenship;

    private String maritalStatus;

    @NotBlank(message = "Permanent address is mandatory")
    @Column(length = 500)
    private String permanentAddress;

    @NotBlank(message = "Contact address is mandatory")
    @Column(length = 500)
    private String contactAddress;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @NotBlank(message = "Mobile number is mandatory")
    private String mobileNumber;

    @NotBlank(message = "Residence category is mandatory")
    private String residenceCategory;

    // Next of Kin (Page 2)
    @NotBlank(message = "Next of kin name is mandatory")
    private String nextOfKinName;

    @NotBlank(message = "Next of kin mobile number is mandatory")
    private String nextOfKinMobile;

    @NotBlank(message = "Next of kin relationship is mandatory")
    private String nextOfKinRelationship;

    @NotBlank(message = "Next of kin residence is mandatory")
    @Column(length = 500)
    private String nextOfKinResidence;

    // Courses (Page 3) - This is a simplified approach.
    // A more normalized approach would have a separate ApplicationCourse table.
    private String firstChoiceCourse;
    private String secondChoiceCourse;
    private String shortCourseChoice;

    // Sponsorship (Page 5)
    private String sponsorshipType; // Private, Government, etc.
    private String sponsorFullName;
    private String sponsorPostalAddress;
    private String sponsorMobileNumber;
    private String sponsorEmailAddress;

    // Link to the User account
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Education background (Page 4) would ideally be a separate @OneToMany entity.
    // For simplicity, we can add key fields here or create an EducationDetails class later.
    private String secondarySchoolName;
    private String secondarySchoolIndexNumber;
}