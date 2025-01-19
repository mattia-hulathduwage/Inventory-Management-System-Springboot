package com.example.inventoryservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface inventoryrepo extends JpaRepository<inventory, Integer> {
    // Custom query to count the number of inventory items based on inventoryId
    @Query("SELECT COUNT(i.inventoryId) FROM inventory i")
    long countInventoryIds();
}
