package com.cognizant.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}