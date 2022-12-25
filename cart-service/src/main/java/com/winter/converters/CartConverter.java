package com.winter.converters;

import com.example.api.CartDto;
import com.winter.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartConverter {
        private final CartItemConverter converter;

        public CartDto modelToDto(Cart cart){
                CartDto cartDto = new CartDto();
                cartDto.setTotalPrice(cart.getTotalPrice());
                cartDto.setItems(cart.getItems().stream().map(converter::modelToDto).collect(Collectors.toList()));
                return cartDto;

        }
}
