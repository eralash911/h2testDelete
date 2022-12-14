package com.example.h2testdelete.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private Integer price;
    private String categoryTittle;


}

