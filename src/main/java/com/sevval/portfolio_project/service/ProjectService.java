package com.sevval.portfolio_project.service;

//project entity'sini bu servis katmanında kullanacağız çünkü
//metotlarımızın parametreleri ve dönüş türleri project türünde olacak
import com.sevval.portfolio_project.entity.Project;

import java.util.List;
import java.util.Optional;

/**
 * project service bir interface'dir
 * burada sadece ne yapacağımızı tanımlayıp nasıl yapacağımızı yazmıyoruz
 * kullanım amacı implementasyonu istediğimiz zaman değiştirebilmemiz için esneklik sağlar
 * controller gibi daha üst katmanlar bu interface üzerinden çalışır.
 * solid prensiplerinden interface segregation ve dependency inversion ile uyumludur**/

public interface ProjectService {

    List<Project> getAllProjects();
    /**tüm projeleri veritabanından getirir
     * tüm projeleri return eder**/


    Optional<Project> getProjectById(Long id);

    /**belirli bir id ye sahip projeyi getirir.
     * aranacak projenin database idsi
     * eğer varsa döner yoksa boş döner**/

    Project createProject(Project project);
    /**yeni prohe kaydetmek veya mevcut projeyi güncellemek için kullanılır**/

    void deleteProject(Long id);
    /**belirli bir id ye sahip projeyi siler, dönüş türü void, bir şey dönmez**/
}
