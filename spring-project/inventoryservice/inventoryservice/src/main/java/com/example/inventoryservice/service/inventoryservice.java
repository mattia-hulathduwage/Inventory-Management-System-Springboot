package com.example.inventoryservice.service;

import com.example.inventoryservice.data.inventory;
import com.example.inventoryservice.data.inventoryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class inventoryservice {

    @Autowired
    private inventoryrepo inventoryrepo;

    // Method to get all inventories
    public List<inventory> getInventories() {
        return inventoryrepo.findAll();
    }

    // Method to get inventory by ID
    public inventory getInventoryById(int id) {
        Optional<inventory> inventory = inventoryrepo.findById(id);
        return inventory.orElse(null);  // Return null if inventory not found
    }

    // Method to create new inventory
    public inventory createInventory(inventory inventory) {
        return inventoryrepo.save(inventory);
    }

    // Method to update an existing inventory
    public inventory updateInventory(inventory inventory) {
        return inventoryrepo.save(inventory);
    }

    // Method to update only stock of an inventory
    public inventory updateInventoryStock(inventory inventory) {
        Optional<inventory> existingInventory = inventoryrepo.findById(inventory.getInventoryId());
        if (existingInventory.isPresent()) {
            inventory updatedInventory = existingInventory.get();
            updatedInventory.setStock(inventory.getStock());  // Update stock
            updatedInventory.setLastUpdate(new java.util.Date());  // Update last update time
            return inventoryrepo.save(updatedInventory);
        }
        return null;  // Return null if inventory not found
    }

    // Method to get the count of inventory items
    public long getInventoryCount() {
        return inventoryrepo.countInventoryIds();
    }

    // Method to delete inventory by ID
    public boolean deleteInventory(int id) {
        if (inventoryrepo.existsById(id)) {
            inventoryrepo.deleteById(id);
            return true;
        }
        return false;
    }
}
