package com.example.productcatalogserviceproxy.Repositories;

import com.example.productcatalogserviceproxy.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    Product save(Product product);
    Product findAllById(Long a);
    List<Product> findProductByPriceBetween(double low,Double high);
    List<Product> findAllByOrderByIdDesc();
    List<Product> findAllByIsSpecialTrue();
    @Query("select p.title from Product p where p.id=?1")
    String getProductTitleFromId(Long id);
    @Query("select c.name from Category c join Product p on c.id=p.category.id where p.id=:id1")
    String getCategoryNameFromProductId(@Param("id1")Long Id);

}
