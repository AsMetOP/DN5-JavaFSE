package com.cognizant.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}