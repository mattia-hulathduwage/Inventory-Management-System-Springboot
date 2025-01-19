package com.example.orderservice.service;

import com.example.orderservice.data.sales;
import com.example.orderservice.data.salesrepo;
import com.example.orderservice.dto.SalesPendingDTO;
import com.example.orderservice.dto.dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class salesservice {

    @Autowired
    private salesrepo salesRepo;

    // Method to get all sales
    public List<sales> getSales() {
        return salesRepo.findAll();
    }

    // Method to get a sale by ID
    public sales getSaleById(int id) {
        Optional<sales> sale = salesRepo.findById(id);
        return sale.orElse(null);  // Return null if sale not found
    }

    // Method to create a new sale
    public sales createSale(sales sale) {
        return salesRepo.save(sale);
    }

    // Method to update an existing sale
    public sales updateSale(sales sale) {
        return salesRepo.save(sale);
    }

    // Method to get the sum of quantity grouped by inventoryId
    public List<dto> getQuantitySumGroupedByInventoryId() {
        List<Object[]> rawResults = salesRepo.sumQuantityGroupedByInventoryId();
        List<dto> result = new ArrayList<>();

        for (Object[] rawResult : rawResults) {
            int inventoryId = (int) rawResult[0];
            Long quantityLong = (Long) rawResult[1]; // The result is a Long
            int quantity = quantityLong.intValue(); // Convert Long to int

            result.add(new dto(inventoryId, quantity));
        }

        return result;
    }

    public long getSalesCount() {
        return salesRepo.countSalesIds();
    }

    public Double getTotalSalesAmountPaid() {
        return salesRepo.getTotalSalesAmountPaid();
    }

    public List<SalesPendingDTO> getPendingDeliverySales() {
        return salesRepo.findSalesWithPendingDelivery();
    }

    // Method to delete a sale by ID
    public boolean deleteSale(int id) {
        if (salesRepo.existsById(id)) {
            salesRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
