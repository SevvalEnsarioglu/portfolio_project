package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Education;

import java.util.List;
import java.util.Optional;

public interface EducationService {
    List<Education> getAllEducations();
    Optional<Education> getEducationById(Long id);
    Education createEducation(Education education);
    void deleteEducation(Long id);
}
