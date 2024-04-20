package com.example.productcatalogserviceproxy.Controllers;

import com.example.productcatalogserviceproxy.Clients.FakeStoreAPI.DTOs.FakeStoreProductDTO;
import com.example.productcatalogserviceproxy.DTOs.ProductDTO;
import com.example.productcatalogserviceproxy.Models.Category;
import com.example.productcatalogserviceproxy.Models.Product;
import com.example.productcatalogserviceproxy.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    IProductService iProductService;
    ProductController(IProductService iProductService){
        this.iProductService=iProductService;
    }
    @GetMapping("/products")
    public List<Product> getProducts(){
        return iProductService.getProducts();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id")Long productId){
        try {
            if(productId<1){
                throw new IllegalArgumentException("Not acceptable product ID");
            }
            MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
            headers.add("Called by","Frontend");
            Product product = iProductService.getProduct(productId);
            return new ResponseEntity<>(product,headers, HttpStatus.OK);
        }
        catch (Exception exception){
            throw exception;
        }
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody ProductDTO productDTO)
    {
        Product product=getProduct(productDTO);
        return iProductService.createProduct(product);
    }
    @PatchMapping("/products/{id}")
   public Product updateProduct(@PathVariable ("id")Long productID,@RequestBody ProductDTO productDTO){
        Product product=getProduct(productDTO);
        return iProductService.updateProduct(productID,product);
    }
    private Product getProduct(ProductDTO ProductDTO){
        Product product=new Product();
        product.setId(ProductDTO.getId());
        product.setTitle(ProductDTO.getTitle());
        product.setPrice(ProductDTO.getPrice());
        product.setDescription(ProductDTO.getDescription());
        product.setImageURL(ProductDTO.getImage());
        Category category=new Category();
        category.setName(ProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }


}



