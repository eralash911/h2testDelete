package com.example.h2testdelete.controller;

import com.example.h2testdelete.model.Cart;
import com.example.h2testdelete.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id){
        cartService.add(id);

    }

    @GetMapping
    public Cart getCurrentCart(){
        return cartService.getCurrentCart();
    }

    @GetMapping("/increase/{id}")
    public void increaseProd(@PathVariable Long id) {

    }
    @GetMapping("/decrease/{id}")
    public void decreaseProd(@PathVariable long id){


    }

    @GetMapping("/remove/{id}")
    public void removeProd(@PathVariable long id){
        cartService.remove(id);

    }

    @GetMapping("/clear")
    public void clearCart(){
        cartService.clear();

    }
}
