package com.example.productcatalogserviceproxy.Models;

import com.example.productcatalogserviceproxy.Clients.FakeStoreAPI.DTOs.FakeStoreProductDTO;
import com.example.productcatalogserviceproxy.DTOs.RatingDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private Double price;
    private String imageURL;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private boolean isSpecial;
}
