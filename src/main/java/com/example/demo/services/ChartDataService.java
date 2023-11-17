package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ChartDataEntity;
import com.example.demo.repositories.ChartDataRepository;

@Service
public class ChartDataService {
    @Autowired
    private ChartDataRepository chartDataRepository;

    public List<ChartDataEntity> getAllChartData() {
        return chartDataRepository.findAll();
    }

    public ChartDataEntity createChartData(ChartDataEntity chartData) {
        return chartDataRepository.save(chartData);
    }
}
