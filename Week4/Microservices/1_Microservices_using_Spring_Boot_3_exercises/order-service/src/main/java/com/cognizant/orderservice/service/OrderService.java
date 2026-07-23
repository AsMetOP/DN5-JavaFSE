package com.cognizant.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.orderservice.entity.Order;

public interface OrderService {

    Order saveOrder(Order order);

    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long id);

}