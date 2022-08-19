package com.example.Homework7;

import com.example.Homework7.model.Product;
import com.example.Homework7.model.ShoppingCart;
import com.example.Homework7.repository.ProductRepository;
import com.example.Homework7.repository.ShoppingCartRepository;
import com.example.Homework7.service.ProductService;
import com.example.Homework7.service.ShoppingCartService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class ShoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    private ShoppingCart shoppingCart;

    private Product product;
    @BeforeEach
    public void setup(){

        shoppingCart = ShoppingCart.builder()
                .id(1)
                .productList(List.of(product))
                .build();
    }

    @DisplayName("JUnit test for removeProduct method")
    @Test
    public void givenShoppingCartObject_whenRemoveProduct_thenReturnShoppingProductObject(){

        Integer shoppingCartId = 1;
        Integer productId = 1;

        willDoNothing().given(shoppingCartRepository).deleteById(productId);

        // when -  action or the behaviour that we are going test
        shoppingCartService.removeProduct(productId, shoppingCartId);

        // then - verify the output
        verify(shoppingCartRepository, times(1)).deleteById(productId);

    }


}
