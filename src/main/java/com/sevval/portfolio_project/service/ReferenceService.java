package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Reference;

import java.util.List;
import java.util.Optional;

public interface ReferenceService {
    List<Reference> getAllReferences();
    Optional<Reference> getReferenceById(Long id);
    Reference createReference(Reference reference);
    void deleteReference(Long id);
}
