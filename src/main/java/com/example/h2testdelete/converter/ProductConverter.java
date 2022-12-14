package com.example.h2testdelete.converter;

import com.example.h2testdelete.dto.ProductDto;
import com.example.h2testdelete.entity.Category;
import com.example.h2testdelete.entity.Product;
import com.example.h2testdelete.exceptions.ResourceNotFoundException;
import com.example.h2testdelete.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    private final CategoryService categoryService;
    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), product.getCategory().getTittle());
    }

    public Product dtoToEntity(ProductDto productDto){
        Product p = new Product();
        p.setId(productDto.getId());
        p.setPrice(productDto.getPrice());
        p.setTitle(productDto.getTitle());
        Category c = categoryService.findByCategoryName(productDto.getCategoryTittle()).orElseThrow(()->new ResourceNotFoundException("category not found"));
        p.setCategory(c);
        return p;
    }
}
