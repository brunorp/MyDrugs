package com.v1project.MyDrugs.services;

import com.v1project.MyDrugs.exceptions.NotFoundException;
import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.models.dtos.ProductDTO;
import com.v1project.MyDrugs.models.mappers.MapperInterface;
import com.v1project.MyDrugs.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.v1project.MyDrugs.utils.CreateProductTest.instantiateProduct;
import static com.v1project.MyDrugs.utils.CreateProductTest.instantiateProductDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private MapperInterface mapper;

    @InjectMocks
    private ProductService productService;

    private Product product;

    private ProductDTO productDTOTest;

    @BeforeEach
    public void setUp() {
        product = instantiateProduct();
        productDTOTest = instantiateProductDTO();
    }

    @Test
    public void shouldGetAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        allProducts.add(product);

        when(productRepository.findAll()).thenReturn(allProducts);
        when(mapper.toProductDTO(product)).thenReturn(productDTOTest);

        List<ProductDTO> products = productService.getAllProducts();

        verify(productRepository, times(1)).findAll();
        assertEquals(allProducts.get(0).getProductName(), "ProductTest");
        assertNotEquals(products.size(), 0);
    }

    @Test
    public void shouldGetOneProduct() {

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(mapper.toProductDTO(product)).thenReturn(productDTOTest);

        ProductDTO productDTO = productService.getOneProduct(product.getId());

        verify(productRepository, times(1)).findById(anyInt());
        assertEquals(productDTO.getClass(), ProductDTO.class);
        assertEquals(productDTO.getProductName(), "ProductTest");
    }

    @Test
    public void shouldNotFoundProduct() {

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(mapper.toProductDTO(product)).thenReturn(null);

        NotFoundException ex = assertThrows(
                NotFoundException.class,
                () -> productService.getOneProduct(product.getId()),
                "No product found. ID: "+product.getId()
        );
        assertTrue(ex.getMessage().contains("No product found. ID: "+product.getId()));
    }

    @Test
    public void shouldCreateProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product);
        when(mapper.toProductDTO(product)).thenReturn(productDTOTest);

        ProductDTO res = productService.createProduct(product);

        assertNotNull(res);
        assertEquals(res.getClass(), ProductDTO.class);
        assertEquals(productDTOTest, res);
    }

    @Test
    public void deleteProduct() {
        productService.deleteProduct(product.getId());

        verify(productRepository, times(1)).deleteById(product.getId()); //pretty sure it is verify after call
    }
}