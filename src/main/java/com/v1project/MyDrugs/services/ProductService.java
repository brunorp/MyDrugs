package com.v1project.MyDrugs.services;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() throws Exception {
        try{
            return productRepository.findAll();
        }catch(RuntimeException e){
            throw new Exception("Error while getting all the products. Error: ", e);
        }
    }
}
