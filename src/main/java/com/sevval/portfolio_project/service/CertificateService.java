package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Certificate;

import java.util.List;
import java.util.Optional;

public interface CertificateService {
    List<Certificate> getAllCertificates();
    Optional<Certificate> getCertificateById(Long id);
    Certificate createCertificate(Certificate certificate);
    void deleteCertificate(Long id);
}
