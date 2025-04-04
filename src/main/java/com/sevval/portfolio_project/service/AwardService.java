package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Award;

import java.util.List;
import java.util.Optional;

public interface AwardService {
    List<Award> getAllAwards();
    Optional<Award> getAwardById(Long id);
    Award createAward(Award award);
    void deleteAward(Long id);
}
