package com.example.h2testdelete.converter;

import com.example.h2testdelete.dto.CategoryDto;
import com.example.h2testdelete.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryConverter {

    private final ProductConverter productConverter;

    public CategoryDto entityToDto(Category category){
    CategoryDto c = new CategoryDto();
    c.setId(category.getId());
    c.setTittle(category.getTittle());
    c.setProducts(category.getProducts().stream().map(productConverter::entityToDto).collect(Collectors.toList()));
    return c;
    }
}
