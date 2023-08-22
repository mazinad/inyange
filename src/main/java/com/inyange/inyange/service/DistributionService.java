package com.inyange.inyange.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
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
