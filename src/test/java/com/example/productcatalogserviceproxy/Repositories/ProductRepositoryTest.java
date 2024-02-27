package com.example.productcatalogserviceproxy.Repositories;

import com.example.productcatalogserviceproxy.Models.Category;
import com.example.productcatalogserviceproxy.Models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ProductRepositoryTest {
    @Autowired
  private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateLoading(){           //______Class 10
        Category category=categoryRepository.findById(1L).get();
        System.out.println(category.getName());
//        List<Product> products=category.getProducts();
//        for(Product product:products){
//            System.out.println(product.getId());
//        }
    }
    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateFetchModes(){                   //______Class 11
        Category category=categoryRepository.findById(1L).get();
        System.out.println(category.getName());
        List<Product> products=category.getProducts();
        for(Product product:products){
            System.out.println(product.getId());
        }
   }


    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateNplusOneProblem(){              //______Class 11
        List<Category> categories=categoryRepository.findAll();
        for(Category category:categories) {
            List<Product> products=category.getProducts();
            if(!products.isEmpty())
                System.out.println(products.get(0).getPrice());
        }
    }
    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateHowJpaWritesQueries(){                 //______Class 11
         //Product product=productRepository.findAllById(1L);
        //  List<Product> products=productRepository.findProductByPriceBetween(90D,105D);
       // List<Product> products=productRepository.findAllByOrderByIdDesc();
        //List<Product> products=productRepository.findAllByIsSpecialTrue();4
        //String name= productRepository.getProductTitleFromId(1L);
        String name=productRepository.getCategoryNameFromProductId(1L);
        System.out.println("debug");

    }

}