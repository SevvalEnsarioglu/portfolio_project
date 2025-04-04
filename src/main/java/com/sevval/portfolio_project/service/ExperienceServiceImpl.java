package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Experience;
import com.sevval.portfolio_project.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//bu class experience service interface'ini uygulayacak, nasıl çalıştığını belirteceğiz
//dependency inversion, üst sınıf alt sınıfa değil arayüze bağımlı olmalı
@Service
public class ExperienceServiceImpl implements ExperienceService{

    private final ExperienceRepository experienceRepository;
    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Optional<Experience> getExperienceById(Long id) {
        return experienceRepository.findById(id);
    }

    @Override
    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}
