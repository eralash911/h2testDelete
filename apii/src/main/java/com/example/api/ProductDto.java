package com.example.api;


import java.math.BigDecimal;

public class ProductDto {
    private Long id;
    private String title;
    private Integer price;
    private String categoryTittle;

    public ProductDto(Long id, String title, BigDecimal price, String categoryTittle) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryTittle = categoryTittle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategoryTittle() {
        return categoryTittle;
    }

    public void setCategoryTittle(String categoryTittle) {
        this.categoryTittle = categoryTittle;
    }
}

