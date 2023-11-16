package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
