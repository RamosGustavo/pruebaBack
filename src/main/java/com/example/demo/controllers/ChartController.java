package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ChartDataEntity;
import com.example.demo.services.ChartDataService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChartController {
    @Autowired
    private ChartDataService chartDataService;

    @GetMapping("/chart-data")
    public ResponseEntity<List<ChartDataEntity>> getChartData() {
        List<ChartDataEntity> chartData = chartDataService.getAllChartData();
        return ResponseEntity.ok(chartData);
    }

    @PostMapping("/chart-data")
    public ResponseEntity<ChartDataEntity> createChartData(@RequestBody ChartDataEntity chartData) {
        ChartDataEntity createdChartData = chartDataService.createChartData(chartData);
        return ResponseEntity.ok(createdChartData);
    }
}

