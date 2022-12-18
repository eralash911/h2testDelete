package com.winter.core.converter;

import com.example.api.ResourceNotFoundException;
import com.example.api.ProductDto;
import com.winter.core.entity.Category;
import com.winter.core.entity.Product;
import com.winter.core.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    private final CategoryService categoryService;
    public com.example.api.ProductDto entityToDto(Product product){
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
