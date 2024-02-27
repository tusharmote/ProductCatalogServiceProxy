package com.example.productcatalogserviceproxy.Repositories;

import com.example.productcatalogserviceproxy.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
