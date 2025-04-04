package com.sevval.portfolio_project.service;

import com.sevval.portfolio_project.entity.User;
import com.sevval.portfolio_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * bean kavramı, spring in yönetimi altında olan, ihtiyaç duyulduğunda otomatik olarak oluşturulan ve
 * uygulama boyunca kullanılan nesnelere denir. spring'in kontrol ettiği nesnedir.
 * bean: spring in kontrol ettiği nesne**/

/**
 * Sınıfını tanımlarsın
 * Spring'e bu sınıfın bir “bean” olduğunu söylersin → @Component, @Service, @Repository, @Controller
 * Spring uygulama başlarken bu sınıfın tek bir örneğini (instance) oluşturur ve yönetir.
 * spring bean, autowired gibi anotasyonlarla başka sınıflarda kullanılabilir**/

import java.util.List; //birden çok kullanıcıyı döndürebilmek için
import java.util.Optional; // kullanıcı bulunmadığında hata fırlatmak yerine boş olabilir demek için

/**
 * user service impl, user serviceyi implemente eder, gerçekleştirir
 * yani burada metotların nasıl çalıştığı, işin mantığı yazılır
 * solid single responsibility ve dependency inversion prensiplerine uygun oldu **/

@Service //spring e bu sınıfın bir service olduğunu belirten anotasyondur, otomatik olarak inject edilir
public class UserServiceImpl implements UserService {
    //user service de ne yapılacağını tanımladık burada nasıl yapılacağını açıklıyoruz

    private final UserRepository userRepository; //bu class'ta user repository ye ihtiyaç duyulacak
    //final, bu değişkenin değiştirilemeyip sadece bir kez constructor da atanacağını gösterir
    /** burada yeni bir nesne oluşturmamamız, bu classın bağımlılığı olan repository'nin
    spring tarafından verilmesi dependency injection, bağımlılığın enjekte edilmesi.
    dependency injection'ın nesnesinin constructor'ının da aşağıda oluşturulması durumu ise
     constructor injection'dır **/
    // autowired implementation sınıfının repository nesnesini constructor ile almasını sağlayan anotasyon
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**user service interface'i implemente edildiği için bu interface içinde tanımlanan metotları override
     etmemiz gerekir**/
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();  //veritabanındaki tüm user kayıtlarını döner
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);  //id ye göre bulur
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);  //id yoksa ekler, varsa günceller
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);  //belirli bir id deki kullanıcıyı siler

    }
}
