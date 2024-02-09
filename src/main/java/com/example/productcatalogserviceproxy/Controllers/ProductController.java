package com.example.productcatalogserviceproxy.Controllers;

import com.example.productcatalogserviceproxy.DTOs.ProductDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @GetMapping("/products")
    public String getProducts(){
        return "Returning list of all products";
    }
    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable("id") String id){
        return "Returning product with id "+id;
    }
    @PostMapping("/products")
    public String createProduct(@RequestBody ProductDTO productDTO){
        return "Creating a new product "+productDTO;}
    @PatchMapping("/products")
   public String updateProduct(@RequestBody ProductDTO productDTO){
        return "Updated Product "+productDTO;
    }

}



