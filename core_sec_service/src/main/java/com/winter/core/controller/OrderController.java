package com.winter.core.controller;

import com.example.api.ResourceNotFoundException;
import com.winter.core.entity.User;
import com.winter.core.service.OrderService;
import com.winter.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(()->new ResourceNotFoundException("user not found"));
        orderService.createOrder(user);
    }
}
