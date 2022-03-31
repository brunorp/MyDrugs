package com.v1project.MyDrugs.services;

import com.v1project.MyDrugs.exceptions.NotFoundException;
import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.models.dtos.ProductDTO;
import com.v1project.MyDrugs.models.mappers.MapperInterface;
import com.v1project.MyDrugs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final MapperInterface mapper;

    @Autowired
    public ProductService(ProductRepository productRepository, MapperInterface mapper){
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream()
                .map(mapper::toProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getOneProduct(int id) {
        return productRepository.findById(id)
                .map(mapper::toProductDTO)
                .orElseThrow(
                        () -> new NotFoundException("No product found. ID: " + id)
                );
    }

    public ProductDTO createProduct(Product product){
        try{
            Product res = productRepository.save(product);

            return mapper.toProductDTO(res);
        } catch (RuntimeException e){
            throw new RuntimeException("Error while creating the product. Error: ", e);
        }
    }

    public void deleteProduct(int id){
        try{
            productRepository.deleteById(id);
        }catch(RuntimeException e){
            throw new RuntimeException("Error while creating the product. Error: ", e);
        }
    }
}
