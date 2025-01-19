package com.example.stockservice.service;

import com.example.stockservice.data.stock;
import com.example.stockservice.data.stockrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class stockservice {

    @Autowired
    private stockrepo stockRepo;

    // Method to get all stocks
    public List<stock> getStocks() {
        return stockRepo.findAll();
    }

    // Method to get stock by ID
    public stock getStockById(int id) {
        Optional<stock> stock = stockRepo.findById(id);
        return stock.orElse(null);  // Return null if stock not found
    }

    // Method to create new stock
    public stock createStock(stock stock) {
        return stockRepo.save(stock);
    }

    // Method to update an existing stock
    public stock updateStock(stock stock) {
        return stockRepo.save(stock);
    }

    // Method to delete stock by ID
    public boolean deleteStock(int id) {
        if (stockRepo.existsById(id)) {
            stockRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
