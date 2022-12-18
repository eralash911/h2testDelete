package com.winter.core.repository;

import com.winter.core.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category>findByCategoryName(String name);
}
