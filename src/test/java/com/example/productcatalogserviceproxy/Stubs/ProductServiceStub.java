package com.example.productcatalogserviceproxy.Stubs;

import com.example.productcatalogserviceproxy.Controllers.ProductController;
import com.example.productcatalogserviceproxy.DTOs.ProductDTO;
import com.example.productcatalogserviceproxy.Models.Product;
import com.example.productcatalogserviceproxy.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceStub implements IProductService {
    Map<Long,Product> products;
    ProductServiceStub(){
        products=new HashMap<>();
    }
    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProduct(Long productId) {
        products.get(productId);
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        products.put(product.getId(),product);
        return products.get(product.getId());
    }

    @Override
    public Product updateProduct(Long productID, Product product) {
        return null;
    }
}
