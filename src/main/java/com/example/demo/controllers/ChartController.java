package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ChartDataDTO;
import com.example.demo.models.ChartDataItemDTO;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChartController {

    @CrossOrigin(origins = "*")
    @GetMapping("/chart-data")
    public ResponseEntity<ChartDataDTO> getChartData() {
        ChartDataDTO chartData = new ChartDataDTO();
        chartData.setLabels(List.of("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));

        ChartDataItemDTO thisWeek = new ChartDataItemDTO();
        thisWeek.setLabel("Esta semana");
        thisWeek.setData(List.of(65, 58, 28, 38, 20, 80, 56));

        ChartDataItemDTO lastWeek = new ChartDataItemDTO();
        lastWeek.setLabel("Semana pasada");
        lastWeek.setData(List.of(90, 42, 36, 44, 26, 62, 70));

        chartData.setDatasets(List.of(thisWeek, lastWeek));

        return ResponseEntity.ok(chartData);
    }
}
