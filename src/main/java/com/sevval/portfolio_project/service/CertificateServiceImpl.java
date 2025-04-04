package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Certificate;
import com.sevval.portfolio_project.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService{
    private final CertificateRepository certificateRepository;
    @Autowired
    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public Optional<Certificate> getCertificateById(Long id) {
        return certificateRepository.findById(id);
    }

    @Override
    public Certificate createCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}
