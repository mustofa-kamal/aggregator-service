package com.example.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDetail {
    private Product product;
    private Review review;
    private Price price;
}
