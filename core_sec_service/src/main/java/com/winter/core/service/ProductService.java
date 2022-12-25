package com.winter.core.service;

import com.example.api.ProductDto;
import com.example.api.ResourceNotFoundException;

import com.winter.core.entity.Category;
import com.winter.core.entity.Product;

import com.winter.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;



    public List<Product> findAll() {
        return productRepository.findAll();
    }

//    public Product findById(Long id) {
//        return productRepository.findById(id);
//    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product createNewProduct(ProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());

        Category category = categoryService.findByCategoryName(productDto.getCategoryTittle()).orElseThrow(()->new ResourceNotFoundException("category not exists"));
        product.setCategory(category);
        productRepository.save(product);
        return product;

    }
}
