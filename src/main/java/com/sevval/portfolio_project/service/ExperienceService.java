package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {

    List<Experience> getAllExperiences(); //tüm deneyimleri veritabanından getirsin
    Optional<Experience> getExperienceById(Long id); //belirli bir deneyimi id ye göre bulsun
    Experience createExperience(Experience experience); //yeni bir deneyimi veritabanına kaydetsin
    void deleteExperience(Long id); //deneyim silsin id ye göre
}
