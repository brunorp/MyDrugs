package com.v1project.MyDrugs.configurations;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.models.User;
import com.v1project.MyDrugs.repositories.ProductRepository;
import com.v1project.MyDrugs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.List;

@Profile("local")
@Configuration
public class LocalConfig {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public LocalConfig(ProductRepository productRepository, UserRepository userRepository){
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Bean
    public void createProducts(){
        Product product = new Product(1, "ProductTest", "Testing", new BigDecimal("45"));
        Product product2 = new Product(2, "ProductTest2", "Testing2", new BigDecimal("110"));

        productRepository.saveAll(List.of(product, product2));
    }

    @Bean
    public void createUsers(){
        User user = new User(1, "testUsername", "testPass");
        User user2 = new User(2, "testUsername2", "testPass2");

        userRepository.saveAll(List.of(user, user2));
    }
}
