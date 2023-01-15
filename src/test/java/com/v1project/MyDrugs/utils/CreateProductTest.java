package com.v1project.MyDrugs.utils;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.models.dtos.ProductDTO;

import java.math.BigDecimal;

public class CreateProductTest {

    public static Product instantiateProduct(){
        return new Product(1, "ProductTest", "Testing", new BigDecimal("45"));
    }
    public static ProductDTO instantiateProductDTO(){
        return ProductDTO.builder()
                .id(1)
                .tag("Testing")
                .productName("ProductTest")
                .price(new BigDecimal("45"))
                .build();
    }

}
