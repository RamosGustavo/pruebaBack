package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.MenuItem;
import com.example.demo.repositories.MenuItemRepository;

import java.util.List;

@Service
public class MenuService {

    private MenuItemRepository menuItemRepository;

    public MenuService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
}
