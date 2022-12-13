package com.example.h2testdelete.service;

import com.example.h2testdelete.entity.Category;
import com.example.h2testdelete.repository.CategoryRepository;
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
