package com.sevval.portfolio_project.repository;


import com.sevval.portfolio_project.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long>{
}
