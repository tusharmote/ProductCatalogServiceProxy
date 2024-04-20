package com.example.productcatalogserviceproxy.Services;

import com.example.productcatalogserviceproxy.Models.Product;
import com.example.productcatalogserviceproxy.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class StorageProductService implements IProductService{
    ProductRepository productRepository;
    StorageProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProduct(Long productId) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Product resultingProduct=productRepository.save(product);
        return resultingProduct;
    }

    @Override
    public Product updateProduct(Long productID, Product product) {
        return null;
    }
}
