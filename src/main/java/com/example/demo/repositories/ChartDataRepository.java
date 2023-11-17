package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ChartDataEntity;

public interface ChartDataRepository extends JpaRepository<ChartDataEntity, Long> {

}
