package com.v1project.MyDrugs.controllers;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.models.dtos.ProductDTO;
import com.v1project.MyDrugs.services.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        log.info("Starting to get product");
        ProductDTO productDTO = productService.getOneProduct(id);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
