package com.inyange.inyange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inyange.inyange.model.School;

public interface schoolRepository extends JpaRepository<School,Long> {
    
}
