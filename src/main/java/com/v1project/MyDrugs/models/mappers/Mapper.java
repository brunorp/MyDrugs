package com.v1project.MyDrugs.models.mappers;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.models.dtos.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper implements MapperInterface {

    @Override
    public Product toProduct(ProductDTO productDTO) {
        return new Product(
               productDTO.getId(),
               productDTO.getProductName(),
               productDTO.getTag(),
               productDTO.getPrice()
       );
    }

    @Override
    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getTag(),
                product.getPrice()
        );
    }
}
