package com.college.cms.dto.requestDTOs;

import lombok.Data;

@Data
public class SponsorshipRequest {
    private String sponsorshipType;
    private String sponsorFullName;
    private String sponsorPostalAddress;
    private String sponsorMobileNumber;
    private String sponsorEmailAddress;
}
