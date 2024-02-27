package com.example.productcatalogserviceproxy.Services;

import com.example.productcatalogserviceproxy.DTOs.ProductDTO;
import com.example.productcatalogserviceproxy.Models.Product;

import java.util.List;

public interface IProductService {
   List<Product> getProducts();

    Product getProduct(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Long productID,Product product);
}
