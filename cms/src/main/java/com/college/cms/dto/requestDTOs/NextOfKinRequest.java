package com.college.cms.dto.requestDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NextOfKinRequest {
    @NotBlank private String nextOfKinName;
    @NotBlank private String nextOfKinMobile;
    @NotBlank private String nextOfKinRelationship;
    @NotBlank private String nextOfKinResidence;
}
