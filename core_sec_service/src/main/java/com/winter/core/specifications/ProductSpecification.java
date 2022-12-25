package com.winter.core.specifications;

import com.winter.core.entity.Product;
import org.springframework.data.jpa.domain.Specification;


public class ProductSpecification {
    public static Specification<Product> tittleContains(String word){
        if (word == null){
            return Specification.of(null)
        }return (root, )
    }
}
