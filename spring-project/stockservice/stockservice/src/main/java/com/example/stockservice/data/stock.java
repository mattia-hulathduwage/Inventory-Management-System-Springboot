package com.example.stockservice.data;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
public class stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stockid")
    private int stockId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "inventoryid")
    private int inventoryId;

    @Column(name = "date")
    private Date date;

    // Getters and Setters
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
