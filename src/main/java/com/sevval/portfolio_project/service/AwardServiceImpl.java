package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.Award;
import com.sevval.portfolio_project.repository.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AwardServiceImpl implements AwardService {

    private final AwardRepository awardRepository;

    @Autowired
    public AwardServiceImpl(AwardRepository awardRepository) {
        this.awardRepository = awardRepository;
    }


    @Override
    public List<Award> getAllAwards() {
        return awardRepository.findAll();
    }

    @Override
    public Optional<Award> getAwardById(Long id) {

        return awardRepository.findById(id);
    }

    @Override
    public Award createAward(Award award) {

        return awardRepository.save(award);
    }

    @Override
    public void deleteAward(Long id) {
        awardRepository.deleteById(id);
    }
}
