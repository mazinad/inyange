package com.inyange.inyange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inyange.inyange.model.Distribution;

public interface DistributionRepository extends JpaRepository<Distribution,Long>{
    
}
