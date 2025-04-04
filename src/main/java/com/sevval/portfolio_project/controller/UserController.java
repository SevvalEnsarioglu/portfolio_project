package com.sevval.portfolio_project.controller;

import com.sevval.portfolio_project.entity.User;
import com.sevval.portfolio_project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//bu class, dış dünyadan gelen HTTP isteklerini karşılayan katman olacak.

@RestController //bu anotasyonla bu class'ın bir REST api controller'ı olduğunu belirttik
@RequestMapping("/api/v1/users") //bu controller, "/api/v1/users" yolundan başlayan istekleri karşılar
public class UserController {
    private final UserService userService; //tüm işlemler UserService üzerinden yapılır, controller service'e bağlı
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //get mapping ile tüm kullanıcıları getirelim
    //response entity, http durum kodlarıyla birlikte veriyi döndürmek için kullanılır
    @GetMapping  //tüm kullanıcıları getir
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers(); //tüm kullanıcıları service katmanından al
        return ResponseEntity.ok(users); //HTTP 200 (OK) ile birlikte kullanıcı listesini döner
    }

    //belirli bir kullanıcıyı id'sine göre getirelim
    @GetMapping("/{id}")  //id ye göre belirli kullanıcıyı getir
    public ResponseEntity<User> getUserById(@PathVariable Long id){ //path variable url yollarındaki dinamik alanları java değişkenine bağlar
        Optional<User> user = userService.getUserById(id); //id'ye göre kullanıcıyı servisten getir
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        //eğer varsa http 200 + user dönsün, yoksa http 404
    }

    //yeni kullanıcı oluşturma, request body'den gelen JSON veriyi User nesnesine dönüştürme
    @PostMapping //yeni kullanıcı ekle
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user); //kullanıcıyı service aracılığıyla kaydet
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); //http 201 dön
    }

    @DeleteMapping("/{id}")  //kullanıcı sil
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id); //service katmanıyla silme işlemi yapılır
        return ResponseEntity.noContent().build(); //http 204 ile no content döner
    }
}






