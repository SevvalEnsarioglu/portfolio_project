package com.sevval.portfolio_project.controller;

import com.sevval.portfolio_project.entity.Education;
import com.sevval.portfolio_project.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//bu controller sınıfı, education ile ilgili http istekleri karşılar,
// /api/v1/educations ile başlayan endpointleri dinler
//tüm işlemler service aracılığıyla yapılır

@RestController //bu, class ın bir rest api olduğunu belirtir yani rest api http isteklerini dinleyip yanıt üretir.
@RequestMapping("/api/v1/educations") //bu controller, /api/v1/educations endpointini temel alır
public class EducationController {
    private final EducationService educationService; //controller, service katmanına bağlı çalışır
    @Autowired
    public EducationController(EducationService educationService) { //constructor injection
        this.educationService = educationService;
    }

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations(){
        List<Education> educations = educationService.getAllEducations();
        return ResponseEntity.ok(educations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id){
        Optional<Education> education = educationService.getEducationById(id);
        return education.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody Education education){
        Education createdEducation = educationService.createEducation(education);
        return new ResponseEntity<>(createdEducation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id){
        educationService.deleteEducation(id);
        return ResponseEntity.noContent().build(); //cevabın son halini döndürmek için build kullanılır
    }
}
