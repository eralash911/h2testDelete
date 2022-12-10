package com.example.h2testdelete.controller;

import com.example.h2testdelete.dto.ProductDto;
import com.example.h2testdelete.entity.Product;
import com.example.h2testdelete.exceptions.AppError;
import com.example.h2testdelete.exceptions.ResourceNotFoundException;
import com.example.h2testdelete.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
@Autowired
    private final ProductService productService;

    @GetMapping
    public List<ProductDto>findAllProd(){

        return productService.findAll().stream().map(product -> new ProductDto(product.getId(), product.getTitle(), product.getPrice())).collect(Collectors.toList());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getProductById (@PathVariable Long id) {
//        Optional<Product> product =productService.findByID(id);
//        if(!product.isPresent()){
//            ResponseEntity<AppError>err = new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), "not found"), HttpStatus.NOT_FOUND);
//            return err;
//        }
//        return new ResponseEntity<>(product.get(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        Product product = productService.findByID(id).orElseThrow(()->new ResourceNotFoundException("product not found"));
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }

    @ExceptionHandler
    public ResponseEntity<AppError>exceptionHandler(ResourceNotFoundException e){
        return  new ResponseEntity<>(new AppError("resource not found", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void delProdById(@PathVariable Long id){
        productService.deleteById(id);
    }




}
