package com.v1project.MyDrugs.controllers;

import com.v1project.MyDrugs.models.dtos.ProductDTO;
import com.v1project.MyDrugs.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.v1project.MyDrugs.utils.CreateProductTest.instantiateProductDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;
    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        productController = new ProductController(productService);
    }

    @Test
    void getAllProducts() {
        List<ProductDTO> allProducts = new ArrayList<>();
        allProducts.add(instantiateProductDTO());

        when(productService.getAllProducts()).thenReturn(allProducts);
        ResponseEntity<List<ProductDTO>> productDTOList = productController.getAllProducts();

        verify(productService, times(1)).getAllProducts();
        assertEquals(productDTOList.getBody(), allProducts);
        assertNotEquals(Objects.requireNonNull(productDTOList.getBody()).size(), 0);
    }

    @Test
    void getProductById() {
        ProductDTO productDTO = instantiateProductDTO();
        when(productService.getOneProduct(productDTO.getId())).thenReturn(productDTO);

        ResponseEntity<ProductDTO> productDTO1 = productController.getProductById(productDTO.getId());

        verify(productService, times(1)).getOneProduct(productDTO.getId());
    }

    @Test
    void createProduct() {
    }

    @Test
    void deleteProduct() {
    }
}