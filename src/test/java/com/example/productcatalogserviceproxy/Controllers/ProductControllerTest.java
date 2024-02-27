package com.example.productcatalogserviceproxy.Controllers;

import com.example.productcatalogserviceproxy.Models.Product;
import com.example.productcatalogserviceproxy.Services.IProductService;
import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;

    @Autowired
    @MockBean     //Mock of product service
    IProductService productService;

    @Test
    @DisplayName("test for returning product successfully")
    public void Test_GetProduct_ReturnsProduct(){
        Product product=new Product();
        product.setId(6L);
        product.setTitle("Unit Test Product");
        product.setPrice(1000D);
        //Arrange
        when(productService.getProduct(any(Long.class))).thenReturn(product);

        //Act
        ResponseEntity<Product> productResponseEntity=productController.getProduct(1L);
        //Assert
        assertNotNull(productResponseEntity);
        assertEquals(1000,productResponseEntity.getBody().getPrice());
        assertEquals("Unit Test Product",productResponseEntity.getBody().getTitle());
        verify(productService,times(1)).getProduct(1L);  //to verify no.of interactions with mocked object

    }
    @Test
    @DisplayName("throws exception in case of error")
    public void Test_GetProduct_InternalDependancy_ThrowsException(){
        //Arrange
        when(productService.getProduct(anyLong())).thenThrow(new RuntimeException("Something went wrong"));

        //Act & Assert
        assertThrows(RuntimeException.class,()->productController.getProduct(1L));
    }

    @Test
    @DisplayName("throws exception for invalid id 0")
    public void Test_GetProduct_InvalidId_ThrowsException(){
        assertThrows(IllegalArgumentException.class,()->productController.getProduct(0L));
    }

}