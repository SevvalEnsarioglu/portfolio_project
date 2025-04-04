package com.sevval.portfolio_project.service;

/**project entity'si bu sınıfın içerisinde kullanılan metotlarda parametre ve dönüş tipi olarak geçiyor**/

import com.sevval.portfolio_project.entity.Project;
import com.sevval.portfolio_project.repository.ProjectRepository;
/**veritabanı işlemlerini gerçekleştirebilmek için project repository ye ihtiyacımız var.
bu sınıf üzerinden save, find by id, find all gibi işlemleri yapacağız**/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * bu sınıf, project service interface'ini implemente eder yani gerçekleştirir.
 * interface'de ne yapacağımızı tanımladık, burada nasıl yapılacağını yazarız
 *
 * bu bakış açısı single responsibility ve dependency inversion (controllerın bu class a değil interface
 * e bağımlı olması) ile uyumludur.**/


@Service //spring e bu sınıfın bir servis sınıfı olduğunu belirten anotasyon. otomatik olarak bean olarak yönetilir
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }


    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
    /**
     * veritabanı işlemlerini yapmak için ProjectRepo kullanacağız.
     * bu nesne dışarıdan spring tarafından constructoru ile verilecek (dependency constructor)
     * final yapma sebebimiz bu değişkenin constructor dışında bir yerde değiştirilememesi içindir
     * bu yöntemle spring bu sınıfa ProjectRepo yu sağlar
     * autowired sayesinde spring bu constructor'ı kullanarak gerekli bağımlılığı verir
     * bu durum loose coupling yani gevşek bağımlılık sağlar**/









}


