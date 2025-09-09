package com.college.cms.dto;

import jakarta.validation.constraints.AssertTrue;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeclarationDTO {
    @AssertTrue(message = "You must agree to terms")
    private boolean agreeToTerms;
}
