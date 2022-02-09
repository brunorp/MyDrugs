package com.v1project.MyDrugs.controllers;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAllProducts() throws Exception {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
