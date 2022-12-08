package com.example.h2testdelete.repository;

import com.example.h2testdelete.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
