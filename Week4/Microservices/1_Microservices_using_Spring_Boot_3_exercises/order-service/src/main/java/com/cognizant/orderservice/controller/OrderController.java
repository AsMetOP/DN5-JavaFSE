package com.cognizant.orderservice.controller;

import com.cognizant.orderservice.dto.OrderResponse;
import com.cognizant.orderservice.dto.UserDTO;
import com.cognizant.orderservice.entity.Order;
import com.cognizant.orderservice.feign.UserClient;
import com.cognizant.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final UserClient userClient;

    public OrderController(OrderService orderService, UserClient userClient) {
        this.orderService = orderService;
        this.userClient = userClient;
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/{id}/user")
    public OrderResponse getOrderWithUser(@PathVariable Long id) {

        Optional<Order> optionalOrder = orderService.getOrderById(id);

        if (optionalOrder.isEmpty()) {
            return null;
        }

        Order order = optionalOrder.get();
        UserDTO user = userClient.getUserById(order.getUserId());

        return new OrderResponse(order, user);
    }
}