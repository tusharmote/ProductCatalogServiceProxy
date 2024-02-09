package com.example.productcatalogserviceproxy.DTOs;

import com.example.productcatalogserviceproxy.Models.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private String title;
    private String description;
    private Double price;
    private String imageURL;
    private Category category;
}
