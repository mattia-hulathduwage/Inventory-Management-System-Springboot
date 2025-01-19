package com.example.stockservice.presentation;

import com.example.stockservice.data.stock;
import com.example.stockservice.service.stockservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class stockcontroller {

    @Autowired
    private stockservice stockService;

    // Method to get all stocks
    @GetMapping("/all")
    public List<stock> getStocks() {
        return stockService.getStocks();
    }

    // Method to get stock by ID
    @GetMapping("/{id}")
    public stock getStockById(@PathVariable("id") int id) {
        return stockService.getStockById(id);
    }

    // Method to create a new stock
    @PostMapping
    public stock createStock(@RequestBody stock stock) {
        return stockService.createStock(stock);
    }

    @PutMapping("/{id}")
    public stock updateStock(@PathVariable("id") int id, @RequestBody stock stock) {
        stock.setStockId(id);  // Make sure the stock ID is being set
        return stockService.updateStock(stock);  // Ensure this method handles the update properly
    }


    // Method to delete stock by ID
    @DeleteMapping("/{id}")
    public boolean deleteStock(@PathVariable int id) {
        return stockService.deleteStock(id);
    }
}
