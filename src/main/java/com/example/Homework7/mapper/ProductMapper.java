package com.example.Homework7.mapper;

import com.example.Homework7.dto.ProductDTO;
import com.example.Homework7.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);

}
