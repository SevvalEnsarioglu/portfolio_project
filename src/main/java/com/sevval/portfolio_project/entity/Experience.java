package com.sevval.portfolio_project.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String type;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    //bir kullanıcı birden fazla deneyime sahip olacağı için many to one ile User'a bağlayalım
    //bu experience bir user'a aittir, bir kullanıcının birden çok deneyimi olabilir
    //fetch type, user verisi ihtiyac olduğunda (lazy) mı çekilsin her zaman (eager) mı belirtir
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //veritabanındaki foreign key kolonu
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Experience(){

    }
}
