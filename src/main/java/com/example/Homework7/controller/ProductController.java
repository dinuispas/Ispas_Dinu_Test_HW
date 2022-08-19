package com.example.Homework7.controller;

import com.example.Homework7.dto.ProductDTO;
import com.example.Homework7.model.Product;
import com.example.Homework7.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    @Autowired
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("all")
    public List<ProductDTO> getAllProductsAndDeletedOnes() {
        return productService.getAllProductsAndDeletedOnes();
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("{id}/{newStock}")
    public Product updateStock(@PathVariable Integer id, @PathVariable Integer newStock) {
        return productService.updateStock(id, newStock);
    }

    @PostMapping("increment/{id}")
    public void incrementStock(@PathVariable Integer id) {
        productService.incrementStock(id);
    }

    @PostMapping("decrement/{id}")
    public void decrementStock(@PathVariable Integer id) {
        productService.decrementStock(id);
    }

}
