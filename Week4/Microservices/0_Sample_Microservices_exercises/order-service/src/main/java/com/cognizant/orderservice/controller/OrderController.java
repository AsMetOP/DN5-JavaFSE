package com.cognizant.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.orderservice.client.UserClient;
import com.cognizant.orderservice.dto.UserDTO;
import com.cognizant.orderservice.entity.Order;
import com.cognizant.orderservice.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        UserDTO user = userClient.getUserById(order.getUserId());
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found for id: " + order.getUserId());
        }
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}/with-user")
    public ResponseEntity<?> getOrderWithUser(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    UserDTO user = userClient.getUserById(order.getUserId());
                    return ResponseEntity.ok().body(new Object() {
                        public final Order orderDetails = order;
                        public final UserDTO userDetails = user;
                    });
                })
                .orElse(ResponseEntity.notFound().build());
    }
}