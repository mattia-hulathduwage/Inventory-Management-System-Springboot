package com.example.inventoryservice.data;  // Place it in a suitable package like "dto" or "model"

public class InventoryWithStock {
    private inventory inventory;
    private int stockAmount;

    // Constructor
    public InventoryWithStock(inventory inventory, int stockAmount) {
        this.inventory = inventory;
        this.stockAmount = stockAmount;
    }

    // Getters and Setters
    public inventory getInventory() {
        return inventory;
    }

    public void setInventory(inventory inventory) {
        this.inventory = inventory;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
