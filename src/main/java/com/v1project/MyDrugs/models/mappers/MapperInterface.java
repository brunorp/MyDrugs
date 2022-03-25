package com.v1project.MyDrugs.models.mappers;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.models.dtos.ProductDTO;

public interface MapperInterface {
    Product toProduct(ProductDTO productDTO);
    ProductDTO toProductDTO(Product product);
}
