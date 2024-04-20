package com.example.productcatalogserviceproxy.Controllers;

import com.example.productcatalogserviceproxy.DTOs.ProductDTO;
import com.example.productcatalogserviceproxy.Models.Product;
import com.example.productcatalogserviceproxy.Services.IProductService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductControllerProductFlowTest {
    @Autowired
    ProductController productController;
    @Autowired
    IProductService iProductService;
    private static final Logger logger = LoggerFactory.getLogger(ProductControllerProductFlowTest.class);

    @Test
    public void Test_Get_Create_Update_Product_ReturnsSuccessfully(){
        //Arrange                                  //here we are using stubs class as implementation of IproductService
        ProductDTO productDTO=new ProductDTO();
        productDTO.setId(1L);
        productDTO.setTitle("ABC");
        productDTO.setDescription("XYZ");

        //ACT
        Product product=productController.createProduct(productDTO);
        ResponseEntity<Product> fetched_product=productController.getProduct(product.getId());
        //logger.info(ResponseEntity<Product> fetched_product);

        //Assert
        assertEquals(HttpStatus.OK,fetched_product.getStatusCode());
       // assertEquals("XYZ",fetched_product.getBody().getDescription());
    }
}
