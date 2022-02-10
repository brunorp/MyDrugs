package com.v1project.MyDrugs.services;

import com.v1project.MyDrugs.exceptions.NoProductFoundException;
import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Product createProduct(Product product) throws Exception {
        try{
            return productRepository.save(product);
        }catch (RuntimeException e){
            throw new Exception("Error while creating the product. Error: ", e);
        }
    }

    public void deleteProduct(int id) throws Exception {
        try{
            productRepository.deleteById(id);
        }catch(RuntimeException e){
            throw new Exception("Error while creating the product. Error: ", e);
        }
    }

    public Optional<Product> getOneProduct(int id) {
        return Optional.ofNullable(productRepository.findById(id).orElseThrow(
                () -> new NoProductFoundException("No product found. ID: " + id)
        ));
    }
}
