package com.v1project.MyDrugs.configurations;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.List;

@Profile("local")
@Configuration
public class LocalConfig {

    @Autowired
    private ProductRepository productRepository;

    @Bean
    public void createProducts(){
        Product product = new Product(1, "ProductTest", "Testing", new BigDecimal("45"));
        Product product2 = new Product(2, "ProductTest2", "Testing2", new BigDecimal("110"));

        productRepository.saveAll(List.of(product, product2));
    }
}
