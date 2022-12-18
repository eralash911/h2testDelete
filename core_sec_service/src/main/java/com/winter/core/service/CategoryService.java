package com.winter.core.service;

import com.winter.core.entity.Category;
import com.winter.core.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByCategoryName (String name) {
        return categoryRepository.findByCategoryName(name);
    }

}
