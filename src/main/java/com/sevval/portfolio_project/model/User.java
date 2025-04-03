package com.sevval.portfolio_project.model;

import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDateTime;


/**
 * user sınıfı kullanıların temel bilgilerini tutar
 * single responsibility principle uygulanır yani bu sınıf yalnızca veri taşıma görevini üstlenir.
 * jpa ile bu classtai veriler veritabanında otomatik tabloya dönüştürülür
 **/

@Entity // bu sınıfın veritabanında bir tablo olması içindir, entity oluşturuyoruz
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TEMEL BILGILER
    private String name;
    private String surname;
    private String title;
    @Column(length = 1000)
    private String bio;

    //ILETISIM BILGILERI
    private String email;
    private String phone;
    private String location;
    private String imageUrl;
    private String linkedinUrl;
    private String githubUrl;
    private String cvUrl;

    //EGITIM BILGILERI
    private String school;
    private String department;
    private String educationStatus;

    //Liste tipindeki bilgileri ayrı bir tabloda tutacağız

    @ElementCollection
    private List<String> skills;
    @ElementCollection
    private List<String> achievements;
    @ElementCollection
    private List<String> certificates;

    //ZAMAN BILGILERI (olusturulma ve guncellenme)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //ENCAPSULATION
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus(String educationStatus) {
        this.educationStatus = educationStatus;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User(){
        this.createdAt = LocalDateTime.now();
    }


}