package com.college.cms.dto.requestDTOs;

import lombok.Data;

@Data
public class CourseSelectionRequest {
    private String firstChoiceCourse;
    private String secondChoiceCourse;
    private String shortCourseChoice;
}
