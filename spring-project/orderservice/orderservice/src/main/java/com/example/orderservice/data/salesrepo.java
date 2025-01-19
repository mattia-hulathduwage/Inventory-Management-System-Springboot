package com.example.orderservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.orderservice.dto.SalesPendingDTO;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface salesrepo extends JpaRepository<sales, Integer> {
    // Query to fetch the sum of quantity grouped by inventoryId
    @Query("SELECT s.inventoryId, SUM(s.quantity) FROM sales s GROUP BY s.inventoryId")
    List<Object[]> sumQuantityGroupedByInventoryId();

    @Query("SELECT COUNT(s.salesId) FROM sales s")
    long countSalesIds();

    @Query("SELECT SUM(s.total) FROM sales s WHERE s.paymentStatus = 'Paid'")
    Double getTotalSalesAmountPaid();

    @Query("SELECT new com.example.orderservice.dto.SalesPendingDTO(s.salesId, s.inventoryId, s.customerName, s.deliveryStatus) " +
            "FROM sales s WHERE s.deliveryStatus = 'Pending'")
    List<SalesPendingDTO> findSalesWithPendingDelivery();
}
