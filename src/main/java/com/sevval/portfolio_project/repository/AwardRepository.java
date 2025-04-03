package com.sevval.portfolio_project.repository;

import com.sevval.portfolio_project.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long>{
}
