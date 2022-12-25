package com.winter.core.converter;

import com.example.api.CategoryDto;
import com.winter.core.dto.CategoryDto;
import com.winter.core.entity.Category;
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
