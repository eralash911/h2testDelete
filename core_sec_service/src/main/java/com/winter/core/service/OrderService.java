package com.winter.core.service;

import com.example.api.CartDto;
import com.winter.core.entity.Order;
import com.winter.core.entity.OrderItem;
import com.winter.core.integrations.CartServiceIntegration;
import com.winter.core.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final CartServiceIntegration cartServiceIntegration;
    private final OrderRepository orderRepository;

    private final ProductService productService;

    @Transactional
    public void createOrder(String username){
        CartDto cartDto = cartServiceIntegration.getCurrentCart();
        Order order = new Order();
        order.setUsername(username);
        order.setTotalPrice(cartDto.getTotalPrice());
        order.setItems(cartDto.getItems().stream().map(
                cartItem -> new OrderItem(
                        productService.findById(cartItem.getProductId()).get(),
                        order,
                        cartItem.getQuantity(),
                        cartItem.getPrice(),
                        cartItem.getPricePerProduct()
                )
        ).collect(Collectors.toList()));
        orderRepository.save(order);
        cartServiceIntegration.clear();

    }





    public List<Order> findOrdersByUsername(String username) {
        return orderRepository.findAllByUsername(username);
    }
}
