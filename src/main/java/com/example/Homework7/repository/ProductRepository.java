package com.example.Homework7.repository;

import com.example.Homework7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Product t set t.stock = t.stock -1 WHERE t.id = :productId")
    void decrementStock(Integer productId);

    @Transactional
    @Modifying
    @Query("UPDATE Product t set t.stock = t.stock + 1 WHERE t.id = :productId")
    void incrementStock(Integer productId);

}
