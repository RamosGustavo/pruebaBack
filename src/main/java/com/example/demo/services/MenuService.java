package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.MenuItem;
import com.example.demo.repositories.MenuItemRepository;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
}
