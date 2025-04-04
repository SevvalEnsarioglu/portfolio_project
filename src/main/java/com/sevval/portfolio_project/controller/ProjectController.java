package com.sevval.portfolio_project.controller;

import com.sevval.portfolio_project.entity.Project;
import com.sevval.portfolio_project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * bu class, dış dünyadan gelen http isteklerini karşılayan controller katmanıdır.
 * /api/v1/projects endpointi ile başlayan istekleri yönetir
 * crud işlemleri project service üzerinden yapılır**/


@RestController // bu sınıfın bir REST API olduğunu spring e bildiren anotasyon. REST API yani http isteklerini işleyip yanıt üreten yazılım bileşeni
@RequestMapping("/api/v1/projects") //bu controller /api/v1/projects ile başlayan url leri dinler. yani tüm endpointlerin hangi url den başlayacağını belirler
public class ProjectController {
    private final ProjectService projectService; //controller, servis katmanına bağlıdır.

    @Autowired //constructor injection yöntemi kullanılır. autowired anotasyonu spring in otomatik olarak bağımlılığı sağlamasını sağlar
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping  //http get isteklerini karşılamak için kullanılır
    public ResponseEntity<List<Project>> getAllProjects(){ //tüm projeyi döndürür
        List<Project> projects = projectService.getAllProjects(); //servis üzerinden projeleri al
        return ResponseEntity.ok(projects); //200 ok ile listeyi döndür
    }

    @GetMapping("/{id}") //belirli id ye sahip projeyi getirir
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){   //path variable url deki dinamik alanları java değişkenine bağlar
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        //arama sonucunda id varsa 200 ok ile proje dönülür, yoksa 404 not found
        //response entity, veriyi http durum kodlarıyla birlikte dönmek için kullanılır
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project){ //request body, frontend den gelen json'ı project nesnesine dönüştürür
        Project createdProject = projectService.createProject(project); //yeni oluşturulanı veritabanına kaydet
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED); //201 created döner
        //response entity, verilerle birlikte http durum kodu döndürmek için kullanılır
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        projectService.deleteProject(id); //servis üzerinden silme işlemi
        return ResponseEntity.noContent().build(); //204 no content yani işlem başarılı ama içerik yok
    }

}
