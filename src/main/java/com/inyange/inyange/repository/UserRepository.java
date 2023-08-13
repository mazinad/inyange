package com.inyange.inyange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inyange.inyange.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByEmail(String email);
    
}
