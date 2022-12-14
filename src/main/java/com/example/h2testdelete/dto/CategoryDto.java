package com.example.h2testdelete.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String tittle;
    private List<ProductDto> products;
}
