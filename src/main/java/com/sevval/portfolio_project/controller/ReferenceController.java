package com.sevval.portfolio_project.controller;


import com.sevval.portfolio_project.entity.Reference;
import com.sevval.portfolio_project.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/references")
public class ReferenceController {
    private final ReferenceService referenceService;
    @Autowired
    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @GetMapping
    public ResponseEntity<List<Reference>> getAllReferences(){
        List<Reference> references = referenceService.getAllReferences();
        return ResponseEntity.ok(references);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reference> getReferenceById(@PathVariable Long id){
        Optional<Reference> reference = referenceService.getReferenceById(id);
        return reference.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reference> createReference(@RequestBody Reference reference){
        Reference createdReference = referenceService.createReference(reference);
        return new ResponseEntity<>(createdReference, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReference(@PathVariable Long id){
        referenceService.deleteReference(id);
        return ResponseEntity.noContent().build();
    }
}
