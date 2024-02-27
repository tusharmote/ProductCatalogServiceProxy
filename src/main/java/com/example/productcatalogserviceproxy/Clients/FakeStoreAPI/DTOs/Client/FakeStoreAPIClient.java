package com.example.productcatalogserviceproxy.Clients.FakeStoreAPI.DTOs.Client;

import com.example.productcatalogserviceproxy.Clients.FakeStoreAPI.DTOs.FakeStoreProductDTO;
import com.example.productcatalogserviceproxy.Models.Product;
import com.example.productcatalogserviceproxy.Services.FakeStoreProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreAPIClient {
    RestTemplateBuilder restTemplateBuilder;
    FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    public FakeStoreProductDTO getProduct(Long productId){
        RestTemplate restTemplate=restTemplateBuilder.build();
        FakeStoreProductDTO fakeStoreProductDTO=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",FakeStoreProductDTO.class,productId).getBody();
        return fakeStoreProductDTO;

    }
    public List<FakeStoreProductDTO> getProducts(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        FakeStoreProductDTO[] fakeStoreProductDTO=restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDTO[].class).getBody();
        List<FakeStoreProductDTO> products=new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO1:fakeStoreProductDTO){
            products.add(fakeStoreProductDTO1);
        }
        return products;
    }

    public FakeStoreProductDTO createProduct(FakeStoreProductDTO fakeStoreProductDTO)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity=restTemplate.postForEntity("https://fakestoreapi.com/products",fakeStoreProductDTO,FakeStoreProductDTO.class);
        return fakeStoreProductDTOResponseEntity.getBody();

    }
    public FakeStoreProductDTO updateProduct(Long productID,FakeStoreProductDTO fakeStoreProductDTO){

        RestTemplate restTemplate=restTemplateBuilder.build();
        FakeStoreProductDTO fakeStoreProductDTO1=restTemplate.patchForObject("https://fakestoreapi.com/products/{id}",fakeStoreProductDTO,FakeStoreProductDTO.class,productID);
       // ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity=requestForEntity(HttpMethod.PATCH,"https://fakestoreapi.com/products/{id",fakeStoreProductDTO, FakeStoreProductDTO.class,productID);
        return fakeStoreProductDTO1;
    }
}
