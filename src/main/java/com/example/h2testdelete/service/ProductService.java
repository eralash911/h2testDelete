package com.example.h2testdelete.service;

import com.example.h2testdelete.dto.ProductDto;
import com.example.h2testdelete.entity.Category;
import com.example.h2testdelete.entity.Product;
import com.example.h2testdelete.exceptions.ResourceNotFoundException;
import com.example.h2testdelete.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Product> findByID(Long id) {
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
