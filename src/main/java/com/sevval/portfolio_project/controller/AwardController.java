package com.sevval.portfolio_project.controller;

import com.sevval.portfolio_project.entity.Award;
import com.sevval.portfolio_project.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/awards")
public class AwardController {
    private final AwardService awardService;

    @Autowired
    public AwardController(AwardService awardService) {
        this.awardService = awardService;
    }

    @GetMapping
    public ResponseEntity<List<Award>> getAllAwards(){
        List<Award> awards = awardService.getAllAwards();
        return ResponseEntity.ok(awards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Award> getAwardById(@PathVariable Long id){
        Optional<Award> award = awardService.getAwardById(id);
        return award.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Award> createAward(@RequestBody Award award){
        Award createdAward = awardService.createAward(award);
        return new ResponseEntity<>(createdAward, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAward(@PathVariable Long id){
        awardService.deleteAward(id);
        return ResponseEntity.noContent().build();
    }
}
