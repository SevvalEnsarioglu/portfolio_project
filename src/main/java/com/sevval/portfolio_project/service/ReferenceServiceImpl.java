package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Reference;
import com.sevval.portfolio_project.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferenceServiceImpl implements ReferenceService{
    //burada final olması solid deki güvenlilik bağımlılıklarına uyar
    private final ReferenceRepository referenceRepository;

    @Autowired
    public ReferenceServiceImpl(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    @Override
    public List<Reference> getAllReferences() {
        return referenceRepository.findAll();
    }

    @Override
    public Optional<Reference> getReferenceById(Long id) {
        return referenceRepository.findById(id);
    }

    @Override
    public Reference createReference(Reference reference) {
        return referenceRepository.save(reference);
    }

    @Override
    public void deleteReference(Long id) {
        referenceRepository.deleteById(id);
    }
}
