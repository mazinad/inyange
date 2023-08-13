package com.inyange.inyange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inyange.inyange.model.Distribution;
import com.inyange.inyange.repository.DistributionRepository;

@Service
public class DistributionService {
    @Autowired
    private DistributionRepository distributionRepository;

    public List<Distribution> findAllDistribution() {
        return distributionRepository.findAll();
    }
    public Distribution findDistributionById(Long id) {
        return distributionRepository.findById(id).orElse(null);
    }
    public Distribution saveDistribution(Distribution distribution) {
        return distributionRepository.save(distribution);
    }
    public void deleteDistribution(Long id) {
        distributionRepository.deleteById(id);
    }
}
