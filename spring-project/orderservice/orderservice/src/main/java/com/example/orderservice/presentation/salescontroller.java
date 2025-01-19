package com.example.orderservice.presentation;

import com.example.orderservice.data.sales;
import com.example.orderservice.service.salesservice;
import com.example.orderservice.dto.SalesPendingDTO;
import com.example.orderservice.dto.dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class salescontroller {

    @Autowired
    private salesservice salesService;

    // Method to get all sales
    @GetMapping("/all")
    public List<sales> getSales() {
        return salesService.getSales();
    }

    // Method to get sale by ID
    @GetMapping("/{id}")
    public sales getSaleById(@PathVariable("id") int id) {
        return salesService.getSaleById(id);
    }

    // Method to create a new sale
    @PostMapping
    public sales createSale(@RequestBody sales sale) {
        return salesService.createSale(sale);
    }

    // Method to update an existing sale by ID
    @PutMapping("/{id}")
    public sales updateSale(@PathVariable("id") int id, @RequestBody sales sale) {
        sale.setSalesId(id);  // Ensure the sales ID is correctly set
        return salesService.updateSale(sale);
    }

    // Endpoint to get the sum of quantity grouped by inventoryId
    @GetMapping("/quantity-sum/grouped")
    public List<dto> getQuantitySumGroupedByInventoryId() {
        return salesService.getQuantitySumGroupedByInventoryId();
    }

    @GetMapping("/sales/count")
    public long getSalesCount() {
        return salesService.getSalesCount();
    }

    @GetMapping("/sales/total-paid")
    public Double getTotalSalesAmountPaid() {
        return salesService.getTotalSalesAmountPaid();
    }

    @GetMapping("/sales/pending-delivery")
    public List<SalesPendingDTO> getPendingDeliverySales() {
        return salesService.getPendingDeliverySales();
    }

    // Method to delete sale by ID
    @DeleteMapping("/{id}")
    public boolean deleteSale(@PathVariable int id) {
        return salesService.deleteSale(id);
    }
}
