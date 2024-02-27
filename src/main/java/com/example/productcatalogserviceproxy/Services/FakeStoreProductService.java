package com.example.productcatalogserviceproxy.Services;

import com.example.productcatalogserviceproxy.Clients.FakeStoreAPI.DTOs.Client.FakeStoreAPIClient;
import com.example.productcatalogserviceproxy.Clients.FakeStoreAPI.DTOs.FakeStoreProductDTO;
import com.example.productcatalogserviceproxy.DTOs.ProductDTO;
import com.example.productcatalogserviceproxy.Models.Category;
import com.example.productcatalogserviceproxy.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.util.ArrayList;
import java.util.List;

public class FakeStoreProductService implements IProductService {
    private RestTemplateBuilder restTemplateBuilder;
   private FakeStoreAPIClient fakeStoreAPIClient;
    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder,FakeStoreAPIClient fakeStoreAPIClient){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreAPIClient=fakeStoreAPIClient;
    }
    @Override
    public List<Product> getProducts(){
       List<FakeStoreProductDTO> fakeStoreProductDTO=fakeStoreAPIClient.getProducts();
       List<Product> products=new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO1:fakeStoreProductDTO){
            products.add(getProduct(fakeStoreProductDTO1));
        }
        return products;
    }
    @Override
    public Product getProduct(Long productId){
        FakeStoreProductDTO fakeStoreProductDTO=fakeStoreAPIClient.getProduct(productId);
        return getProduct(fakeStoreProductDTO);
    }
    @Override
    public Product createProduct(Product product)
    {
        FakeStoreProductDTO fakeStoreProductDTO=getFakeStoreProductDTO(product);
        Product product1=getProduct(fakeStoreAPIClient.createProduct(fakeStoreProductDTO));
        return product1;
    }

    @Override
    public Product updateProduct(Long productID,Product product){
         FakeStoreProductDTO fakeStoreProductDTO=getFakeStoreProductDTO(product);
         Product product1=getProduct(fakeStoreAPIClient.updateProduct(productID,fakeStoreProductDTO));
        return product1;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
    private Product getProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product=new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImageURL(fakeStoreProductDTO.getImage());
        Category category=new Category();
       category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }
    private FakeStoreProductDTO getFakeStoreProductDTO(Product product){
        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setImage(product.getImageURL());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        return fakeStoreProductDTO;
    }

}
