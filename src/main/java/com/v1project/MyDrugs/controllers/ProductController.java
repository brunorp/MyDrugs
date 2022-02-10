package com.v1project.MyDrugs.controllers;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.services.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Log4j2
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

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Product>> getOne(@PathVariable int id){
        log.info("Starting to get product");
        Optional<Product> product = productService.getOneProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) throws Exception {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public void deleteProduct(@PathVariable int id) throws Exception {
        productService.deleteProduct(id);
    }
}
