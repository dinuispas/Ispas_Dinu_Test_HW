package com.example.Homework7.dto;

import com.example.Homework7.model.ProductType;
import lombok.Data;

@Data
public class ProductDTO {

    ProductType type;
    String name;
    String identificationCode;
    Integer stock;
    Boolean deleted;

}
