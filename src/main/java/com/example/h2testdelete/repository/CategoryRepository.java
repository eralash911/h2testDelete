package com.example.h2testdelete.repository;

import com.example.h2testdelete.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category>findByCategoryName(String name);
}
