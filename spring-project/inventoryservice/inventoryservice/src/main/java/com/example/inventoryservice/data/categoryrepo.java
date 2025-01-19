package com.example.inventoryservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface categoryrepo extends JpaRepository<category, Integer> {
    @Query("SELECT COUNT(c.categoryId) FROM category c")
    long countCategoryIds();
}
