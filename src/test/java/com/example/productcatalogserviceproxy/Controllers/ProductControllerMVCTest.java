package com.example.productcatalogserviceproxy.Controllers;

import com.example.productcatalogserviceproxy.Models.Product;
import com.example.productcatalogserviceproxy.Services.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private IProductService productService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void Test_GetProduct_RecievesSuccessfulResponse() throws Exception{
        //Arrange
        List<Product> result_product_list=new ArrayList<>();
        Product product=new Product();
        product.setTitle("iphone12");
        product.setId(10L);
        Product product2=new Product();
        product.setTitle("MacBook");
        product.setId(20L);
        result_product_list.add(product);
        result_product_list.add(product2);
        when(productService.getProducts()).thenReturn(result_product_list);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(result_product_list)));
       //when(productService.getProducts()).thenReturn();

    }
    @Test
    public void Test_CreateProduct_RecievesSuccessfullResponse() throws Exception{
        Product created_product=new Product();
        created_product.setTitle("Orange");
        created_product.setDescription("Fresh and Juicy");
        Product expected_product=new Product();
        expected_product.setTitle("Orange");
        expected_product.setDescription("Fresh and Juicy");
        expected_product.setId(5L);
        when(productService.createProduct(any(Product.class))).thenReturn(expected_product);
        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(created_product)))
                        .andExpect(status().isOk())
                        .andExpect(content().string(objectMapper.writeValueAsString(expected_product)));
    }
}
