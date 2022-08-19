package com.example.Homework7.repository;

import com.example.Homework7.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    Integer totalPrice();
}
