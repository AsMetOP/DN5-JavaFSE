package com.cognizant.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}