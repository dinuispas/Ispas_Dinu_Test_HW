package com.example.Homework7.service;

import com.example.Homework7.dto.ProductDTO;
import com.example.Homework7.mapper.ProductMapper;
import com.example.Homework7.model.Product;
import com.example.Homework7.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .filter(product -> !product.getDeleted() )
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getAllProductsAndDeletedOnes() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    public void deleteProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            product.get().setDeleted(true);
        }
        productRepository.save(product.get());
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateStock(Integer id, Integer newStock) {
        Product product = productRepository.findById(id).get();
        product.setStock(newStock);
        return productRepository.save(product);
    }

    public void incrementStock(Integer id) {
        productRepository.incrementStock(id);
    }

    public void decrementStock(Integer id) {
        productRepository.decrementStock(id);
    }
}
