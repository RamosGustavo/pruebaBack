package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ChartDataEntity;
import com.example.demo.services.ChartDataService;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/chart-data")
public class ChartController {
    private ChartDataService chartDataService;

    public ChartController(ChartDataService chartDataService) {
        this.chartDataService = chartDataService;
    }

    @GetMapping
    public ResponseEntity<List<ChartDataEntity>> getChartData() {
        List<ChartDataEntity> chartData = chartDataService.getAllChartData();
        return ResponseEntity.status(HttpStatus.OK).body(chartData);
    }

    @PostMapping
    public ResponseEntity<ChartDataEntity> createChartData(@RequestBody @Valid ChartDataEntity chartData) {
        ChartDataEntity createdChartData = chartDataService.createChartData(chartData);
        return ResponseEntity.status(HttpStatus.OK).body(createdChartData);
    }

}