package com.example.inventoryservice.presentation;

import com.example.inventoryservice.data.category;
import com.example.inventoryservice.service.categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class categorycontroller {

    @Autowired
    private categoryservice categoryservice;

    // Method to get all categories
    @GetMapping("/all")
    public List<category> getCategories() {
        return categoryservice.getCategories();
    }

    // Method to get category by ID
    @GetMapping("/{id}")
    public category getCategoryById(@PathVariable("id") int id) {
        return categoryservice.getCategoryById(id);
    }

    // Method to create a new category
    @PostMapping
    public category createCategory(@RequestBody category category) {
        return categoryservice.createCategory(category);
    }

    // Method to update an existing category by ID
    @PutMapping("/{id}")
    public category updateCategory(@PathVariable("id") int id, @RequestBody category category) {
        category.setCategoryId(id);  // Ensure the category ID is correctly set
        return categoryservice.updateCategory(category);
    }

    @GetMapping("/categories/count")
    public long getCategoryCount() {
        return categoryservice.getCategoryCount();
    }


    // Method to delete category by ID
    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable int id) {
        return categoryservice.deleteCategory(id);
    }
}
