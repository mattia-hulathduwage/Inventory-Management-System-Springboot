package com.example.stockservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface stockrepo extends JpaRepository<stock, Integer> {
}
