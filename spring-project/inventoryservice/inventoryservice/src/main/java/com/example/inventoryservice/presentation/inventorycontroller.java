package com.example.inventoryservice.presentation;

import com.example.inventoryservice.data.inventory;
import com.example.inventoryservice.service.inventoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class inventorycontroller {

    @Autowired
    private inventoryservice inventoryservice;

    // Method to get all inventories
    @GetMapping("/all")
    public List<inventory> getInventories() {
        return inventoryservice.getInventories();
    }

    // Method to get inventory by ID
    @GetMapping("/{id}")
    public inventory getInventoryById(@PathVariable("id") int id) {
        return inventoryservice.getInventoryById(id);
    }

    // Method to create a new inventory
    @PostMapping
    public inventory createInventory(@RequestBody inventory inventory) {
        Date currentDate = getCurrentDateWithoutTime();
        inventory.setCreatedAt(currentDate);
        inventory.setLastUpdate(currentDate);

        return inventoryservice.createInventory(inventory);
    }

    // Method to update an existing inventory
    @PutMapping("/{id}")
    public inventory updateInventory(@PathVariable("id") int id, @RequestBody inventory inventory) {
        // Set the id of the updated inventory
        inventory.setInventoryId(id);
        return inventoryservice.updateInventory(inventory);
    }

    // Method to update stock of an existing inventory
    @PatchMapping("/update/{id}")
    public inventory updateInventoryStock(@PathVariable("id") int id, @RequestBody inventory inventory) {
        // Set the id of the updated inventory
        inventory.setInventoryId(id);
        return inventoryservice.updateInventoryStock(inventory);
    }

    @GetMapping("/inventory/count")
    public long getInventoryCount() {
        return inventoryservice.getInventoryCount();
    }

    // Method to delete inventory by ID
    @DeleteMapping("/{id}")
    public boolean deleteInventory(@PathVariable int id) {
        return inventoryservice.deleteInventory(id);
    }

    // Helper method to get current date without time
    private Date getCurrentDateWithoutTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
