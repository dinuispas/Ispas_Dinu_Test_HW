package com.example.Homework7.service;

import com.example.Homework7.model.Product;
import com.example.Homework7.model.ShoppingCart;
import com.example.Homework7.repository.ProductRepository;
import com.example.Homework7.repository.ShoppingCartRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class ShoppingCartService {

    @Autowired
    private final ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private final ProductRepository productRepository;

    public void addProduct(Integer productId, Integer shoppingCartId) {
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        shoppingCart.get().addProduct(product.get());
    }

    public void removeProduct(Integer productId, Integer shoppingCartId) {
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        shoppingCart.get().removeProduct(product.get());
    }

    public Integer totalPrice(Integer shoppingCartId) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        return shoppingCart.get().totalPrice();
    }

    public ShoppingCart createShoppingCart() {
        ShoppingCart sc = new ShoppingCart();
        return shoppingCartRepository.save(sc);
    }
}
