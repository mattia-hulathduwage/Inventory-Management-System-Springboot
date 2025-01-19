package com.example.orderservice.dto;

public class dto {

    private int inventoryId;
    private int quantity;

    // Constructor
    public dto(int inventoryId, int quantity) {
        this.inventoryId = inventoryId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
