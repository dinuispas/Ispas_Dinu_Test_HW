package com.example.Homework7;


import com.example.Homework7.model.Product;
import com.example.Homework7.repository.ProductRepository;
import com.example.Homework7.service.ProductService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private static Product product;

    @BeforeEach
    public void setup(){

        product = Product.builder()
                .name("Fridge")
                .identificationCode("F265")
                .stock(200)
                .deleted(false)
                .price(20)
                .build();

    }

    @DisplayName("JUnit test for saveProduct method")
    @Test
    public void givenProductObject_whenSaveProduct_thenReturnProductObject(){
        given(productRepository.findById(product.getId()))
                .willReturn(Optional.empty());

        given(productRepository.save(product)).willReturn(product);

        System.out.println(productRepository);
        System.out.println(productService);

        // when -  action or the behaviour that we are going test
        Product savedProduct = productService.saveProduct(product);

        System.out.println(savedProduct);
        // then - verify the output
        assertThat(savedProduct).isNotNull();
    }


}
