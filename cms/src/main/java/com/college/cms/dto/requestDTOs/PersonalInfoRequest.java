package com.college.cms.dto.requestDTOs;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonalInfoRequest {
    @NotBlank private String lastName;
    @NotNull private Boolean hasDisability;
    @NotBlank private String firstName;
    @Past private LocalDate dateOfBirth;
    @NotBlank private String gender;
    @NotBlank private String placeOfBirth;
    @NotBlank private String citizenship;
    private String maritalStatus;
    @NotBlank private String permanentAddress;
    @NotBlank private String contactAddress;
    @NotBlank @Email private String email;
    @NotBlank private String mobileNumber;
    @NotBlank private String residenceCategory;
}
