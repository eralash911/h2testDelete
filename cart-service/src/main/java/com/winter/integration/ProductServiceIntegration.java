package com.winter.integration;

import com.example.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {

    private final RestTemplate restTemplate;

    public Optional<ProductDto> getProductById(Long id){
        return Optional.ofNullable( restTemplate.getForObject("http://localhost:/winter/api/products/" + id, ProductDto.class));

    }
}
