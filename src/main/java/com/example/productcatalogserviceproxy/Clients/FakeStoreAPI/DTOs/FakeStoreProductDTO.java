package com.example.productcatalogserviceproxy.Clients.FakeStoreAPI.DTOs;

import com.example.productcatalogserviceproxy.DTOs.RatingDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
    private FakeStoreRatingDTO fakeStoreRatingDTO;

}
