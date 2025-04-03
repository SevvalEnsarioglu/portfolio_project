package com.sevval.portfolio_project.repository;

import com.sevval.portfolio_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * burası user tablosu için veritabanına erişim katmanıdır.
 * solid deki interface segregation uygundur
 * spring data jpa bu interface i otomatik olarak implemente eder**/

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
