package com.example.api;


import java.util.List;

public class CategoryDto {
    private Long id;
    private String tittle;
    private List<ProductDto> products;

    public CategoryDto(Long id, String tittle, List<ProductDto> products) {
        this.id = id;
        this.tittle = tittle;
        this.products = products;
    }
}
