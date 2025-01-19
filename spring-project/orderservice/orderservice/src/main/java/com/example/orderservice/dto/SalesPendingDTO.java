package com.example.orderservice.dto;

public class SalesPendingDTO {

    private int salesId;
    private int inventoryId;
    private String customerName;
    private String deliveryStatus;

    // Constructor
    public SalesPendingDTO(int salesId, int inventoryId, String customerName, String deliveryStatus) {
        this.salesId = salesId;
        this.inventoryId = inventoryId;
        this.customerName = customerName;
        this.deliveryStatus = deliveryStatus;
    }

    // Getters and Setters
    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
