package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {
    List<Language> getAllLanguages();
    Optional<Language> getLanguageById(Long id);
    Language createLanguage(Language language);
    void deleteLanguage(Long id);
}
