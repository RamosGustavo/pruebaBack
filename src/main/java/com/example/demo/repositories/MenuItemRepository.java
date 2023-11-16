package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
