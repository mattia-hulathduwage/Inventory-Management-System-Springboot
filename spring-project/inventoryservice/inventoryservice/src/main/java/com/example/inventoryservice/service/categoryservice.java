package com.example.inventoryservice.service;

import com.example.inventoryservice.data.category;
import com.example.inventoryservice.data.categoryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoryservice {

    @Autowired
    private categoryrepo categoryrepo;

    // Method to get all categories
    public List<category> getCategories() {
        return categoryrepo.findAll();
    }

    // Method to get category by ID
    public category getCategoryById(int id) {
        Optional<category> category = categoryrepo.findById(id);
        return category.orElse(null);  // Return null if category not found
    }

    // Method to create a new category
    public category createCategory(category category) {
        return categoryrepo.save(category);
    }

    // Method to update an existing category
    public category updateCategory(category category) {
        return categoryrepo.save(category);
    }

    public long getCategoryCount() {
        return categoryrepo.countCategoryIds();
    }

    // Method to delete category by ID
    public boolean deleteCategory(int id) {
        if (categoryrepo.existsById(id)) {
            categoryrepo.deleteById(id);
            return true;
        }
        return false;
    }
}
