package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers(); //tüm kullanıcıları getir
    Optional<User> getUserById(Long id); //id ye göre kullanıcıları getirir
    User createUser(User user); //yeni kullanıcı oluşturur user tipinde
    void deleteUser(Long id); // silinecek kullanıcı id si

}
